package array;

import java.io.IOException;
import java.util.Arrays;

import util.CglibProxy;
import util.CommonUtil;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年11月29日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) throws IOException {
        int num = 100000;
        int[] arrays = null;
        CglibProxy cglibProxy = new CglibProxy();
        BubbleSort bubbleSort = (BubbleSort) cglibProxy.newInstall(new BubbleSort());
        CommonUtil.writeIntToTxt(num);
        arrays = CommonUtil.readIntToTxt(num);
        bubbleSort.bubbleSortCommon(arrays);
        CommonUtil.writeIntToTxt(num);
        arrays = CommonUtil.readIntToTxt(num);
        bubbleSort.bubbleSortOptimize(arrays);
        CommonUtil.writeIntToTxt(num);
        arrays = CommonUtil.readIntToTxt(num);
        bubbleSort.bubbleSortOptimize2(arrays);
    }

    //这个是最常见的冒泡排序
    public void bubbleSortCommon(int[] array) {
        for (int index = array.length - 1; index >= 0; index--) {
            for (int second = 0; second < index; second++) {
                if (array[second] > array[second + 1]) {
                    int temp = array[second];
                    array[second] = array[second + 1];
                    array[second + 1] = temp;
                }
            }
        }
    }

    //这是一个优化过后的版本 当一次遍历后不存在元素交换，那么我们就判断他是有序的
    public void bubbleSortOptimize(int[] array) {
        int temp;
        for (int index = array.length - 1; index >= 0; index--) {
            boolean isSorted = true;
            for (int second = 0; second < index; second++) {
                if (array[second] > array[second + 1]) {
                    temp = array[second];
                    array[second] = array[second + 1];
                    array[second + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
    //记录最后一次做交换的位置，如果没有进行交换，那么久证明前面都为有序，跳出循环
    public void bubbleSortOptimize2(int[] array) {
        int temp;
        int sortBorder = array.length - 1;
        int lastExchangeIndex = 0;
        for (int index = 0; index < array.length; index++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            sortBorder = lastExchangeIndex;
        }
    }
}
