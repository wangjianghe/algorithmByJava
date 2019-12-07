package array;

import java.util.Arrays;

import util.CommonUtil;

/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年11月29日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort=new InsertionSort();
        int[] arr= CommonUtil.getRandomArray(1000,0,99999999);
        insertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        arr= CommonUtil.getRandomArray(1000,0,99999999);
        insertionSort.BlnInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
        arr= CommonUtil.getRandomArray(1000,0,99999999);
        insertionSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //直接插入排序
    public void insertionSort(int[] arr){
        int j,temp,i;
        for (i=1;i<arr.length;i++){
            if (arr[i]<arr[i-1]){
                temp=arr[i];
                for (j=i-1;j>=0&&arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
    }
    //折半插入排序
    public void BlnInsertionSort(int[] arr){
            int i,temp,j;
            for (i=1;i<arr.length;i++){
                temp=arr[i];
                int low=0;
                int high=i-1;
                while (low<=high){
                    int mid=(low+high)/2;
                    if (temp<arr[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                for (j=i-1;j>high;j--){
                    arr[j+1]=arr[j];
                }
                arr[high+1]=temp;
            }
    }
    public void shellSort(int[] arr){
        for(int i=(arr.length/3)+1;i>=1;i=(i/3)+1){
            for (int j=i;j<arr.length;j++){
                int k=j;
                int temp=arr[k];
                for (k-=i;k>=0&&temp<arr[k];k-=i){
                    arr[k+i]=arr[k];
                }
                arr[k+i]=temp;
            }
        }
    }

}
