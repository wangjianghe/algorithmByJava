package array;

/**
 * 多线程快排
 */

import util.CommonUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Sort_QuickSortParallel {

    private int[] arr;

    public Sort_QuickSortParallel(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {

        for (int j = 0; j < 20; j++) {
            /********************************************************/


            /******************************************************************/

            int arrLen = 1000_0000;

            /******************************************************************/

            int[] arr = CommonUtil.getRandomArray(1000,0,2556);
            if (args.length > 0) {
                arrLen = Integer.parseInt(args[0]);
            }
            Random random = new Random();
            arr = new int[arrLen];
            for (int i = 0; i < arrLen; i++) {
                arr[i] = random.nextInt(Integer.MAX_VALUE);
            }

            Long time=System.currentTimeMillis();
            new Sort_QuickSortParallel(arr).sort();
            System.out.println("并发快排，数据量 " + arrLen + " 耗时（毫秒） " + (System.currentTimeMillis()-time));

            System.out.println(Arrays.toString(arr));

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    System.out.println(i);
                    System.out.println(arr[i - 1]);
                    System.out.println(arr[i]);
                    throw new RuntimeException("算法错误");
                }
            }

            /********************************************************/
        }

    }

    private void sort() {

        int processors = Runtime.getRuntime().availableProcessors();

        processors *= 2;

        System.out.println("CPU核心数 " + processors);

        int parallelBeginDeep = 0;
        int parThreadCount;
        while (true) {
            parThreadCount = 1 << parallelBeginDeep;
            if (parThreadCount >= processors) {
                System.out.println("最大并发线程数 " + parThreadCount);
                System.out.println("并发起始深度 parallelBeginDeep (start with 0) " + parallelBeginDeep);
                break;
            } else {
                ++parallelBeginDeep;
            }
        }

        ExecutorService exec = Executors.newFixedThreadPool(parThreadCount);

        CountDownLatch downLatch = new CountDownLatch(parThreadCount);

//        DoSort doSort = new DoSort(downLatch, parallelBeginDeep, exec, arr, 0, arr.length - 1);
        QuickSortParallel quickSortParallel = new QuickSortParallel(arr, 0, arr.length - 1, downLatch, parallelBeginDeep, exec);

        exec.execute(quickSortParallel);

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exec.shutdown();
    }


    static class QuickSortParallel extends QuickSort {

        private int deep;
        private ExecutorService exec;

        public QuickSortParallel(int[] arr, int left, int right, CountDownLatch downLatch, int deep, ExecutorService exec) {
            super(arr, left, right, downLatch);
            this.deep = deep;
            this.exec = exec;
        }

        @Override
        public void run() {
            int nil = doSort(left, right);

            if (deep > 1) {
                if (nil - 1 > left)
                    exec.execute(new QuickSortParallel(arr, left, nil - 1, downLatch, deep - 1, exec));
                if (nil + 1 < right)
                    exec.execute(new QuickSortParallel(arr, nil + 1, right, downLatch, deep - 1, exec));
            } else {
                if (nil - 1 > left)
                    exec.execute(new QuickSort(arr, left, nil - 1, downLatch));
                if (nil + 1 < right)
                    exec.execute(new QuickSort(arr, nil + 1, right, downLatch));
            }

        }
    }

    static class QuickSort implements Runnable {

        protected int[] arr;
        protected int left, right;
        protected CountDownLatch downLatch;

        public QuickSort(int[] arr, int left, int right, CountDownLatch downLatch) {
            this.arr = arr;
            this.left = left;
            this.right = right;
            this.downLatch = downLatch;
        }

        @Override
        public void run() {
            doSort_(left, right);
            if (downLatch != null) {
                downLatch.countDown();
//                System.out.println(getClass().getName() + "  " + hashCode()  + "  >>>>>>>>>>>>>>>>>>>>>>>>>>>> downLatch.countDown();");
            }


//            for (int i = left + 1; i < right; i++) {
//                if (arr[i - 1] > arr[i]) {
//                    throw new RuntimeException("error");
//                }
//            }
        }

        private int doSort_(int lef, int rig) {
            int nil = doSort(lef, rig);

            if (nil - 1 > lef)
                doSort_(lef, nil - 1);

            if (nil + 1 < rig)
                doSort_(nil + 1, rig);

            return nil;
        }

        protected int doSort(int lef, int rig) {

            int mv = arr[lef];
            int nil = lef++;

            while (lef <= rig) {

                for (; rig > nil; rig--) {
                    if (arr[rig] < mv) {
                        arr[nil] = arr[rig];
                        nil = rig--;
                        break;
                    }
                }

                for (; lef < nil; lef++) {
                    if (arr[lef] > mv) {
                        arr[nil] = arr[lef];
                        nil = lef++;
                        break;
                    }
                }
            }

            arr[nil] = mv;

            return nil;

        }
    }
}