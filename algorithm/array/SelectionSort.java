package array;

import java.util.Arrays;

import util.CommonUtil;

/**
 *<p>Description:选择排序</p>

 *<p>Create Date:2019年11月29日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr= CommonUtil.getRandomArray(1000,0,25565);
        SelectionSort selectionSort=new SelectionSort();
        selectionSort.selectionSortCommon(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void selectionSortCommon(int arr[]){
        for (int i=0;i<arr.length;i++){
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
