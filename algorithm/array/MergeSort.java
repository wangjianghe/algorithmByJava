package array;

import java.util.Arrays;

import util.CommonUtil;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年12月07日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int[] arr= CommonUtil.getRandomArray(100,0,9999);
        mergeSort.sort(arr,0,99);
        System.out.println(Arrays.toString(arr));
        System.out.println(CommonUtil.JudgeSortSmallToBig(arr));
    }
    public void sort(int[] arr,int left,int right){
        if (left>=right){
            return;
        }
        int mid=(left+right)/2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    private static void merge(int[] arr,int left,int mid,int right){
        int i=left,j=mid+1;
        int[] tempArr=new int[right-left+1];
        int k=0;
            while (j<=right&&i<=mid){
                tempArr[k++]=arr[i]>arr[j]?arr[j++]:arr[i++];
            }
            while (i<=mid){
                tempArr[k++]=arr[i++];
            }
            while (j<=right){
                tempArr[k++]=arr[j++];
            }
            k=0;
            for (int tempArrIndex=left;tempArrIndex<=right;tempArrIndex++){
                arr[tempArrIndex]=tempArr[k++];
            }
    }
}
