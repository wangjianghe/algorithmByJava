package array;

import java.util.Arrays;

import util.CommonUtil;

/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class heapSort {
    public static void main(String[] args) {
        heapSort heapSort=new heapSort();
        int[] arr= CommonUtil.getRandomArray(1000,0,999999);
        heapSort.bigHeap(arr);
        System.out.println(Arrays.toString(arr));
        arr= CommonUtil.getRandomArray(1000,0,999999);
        heapSort.smallHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void bigHeap(int[] arr){
        for (int i=arr.length;i>=0;i--){
            createBigHeap(arr,i);
            if (i>0){
                swap(arr,0,i-1);
            }
        }
    }
    //小顶堆就是换大小
    public void smallHeap(int[] arr){
        for (int i=arr.length;i>=0;i--){
            createSmallHeap(arr,i);
            if (i>0){
                swap(arr,0,i-1);
            }
        }
    }
    public static void createSmallHeap(int[] arr,int length){
        for (int index=(length/2)-1;index>=0;index--){
            int temp=arr[index];
            int k=index*2+1;
            if (k+1<length&&arr[k]>arr[k+1]){
                k++;
            }
            if (arr[k]<temp){
                swap(arr,index,k);
            }
        }
    }
    public static void createBigHeap(int[] arr,int length){
        for (int index=(length/2)-1;index>=0;index--){
            int temp=arr[index];
            int k=index*2+1;
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                swap(arr,index,k);
            }
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
