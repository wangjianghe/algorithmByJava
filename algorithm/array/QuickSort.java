package array;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

import util.CglibProxy;
import util.CommonUtil;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class QuickSort{
    public static void main(String[] args) throws IOException {
        int num=200000;
        CommonUtil.writeIntToTxt(num);
        int[] result=CommonUtil.readIntToTxt(num);
        System.out.println("读写文件完成:"+result.length);
        System.out.println(Arrays.toString(result));
        CglibProxy cglibProxy=new CglibProxy();
        QuickSort quickSort= (QuickSort) cglibProxy.newInstall(new QuickSort());
        QuickSort quickSortNoProxy=new QuickSort();
        quickSort.quickSortByFixed(result,0,result.length-1);
        //quickSort.quickSortByRandom(result,0,result.length-1);
        //quickSort.quickSortByThreeMiddle(result,0,result.length-1);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 固定的取左面第一个数作为切分位置
     * @param array
     * @param left
     * @param right
     */
    public void quickSortByFixed(int[] array,int left,int right){
        if (right<=left||left<0||right>array.length){
            return;
        }
        int value=array[left];
        int i=left;
        int j=right;
        int temp;
        while (i<j){
            while (array[j]>=value&&i<j){
                j--;
            }
            while(array[i]<=value&&i<j){
                i++;
            }
            temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
        array[left]=array[i];
        array[i]=value;
        quickSortByFixed(array,left,j-1);
        quickSortByFixed(array,j+1,right);
    }

    /**
     * 从左面开始作为比较时比较复杂，因为i==j时无法判断这个值的大小情况，所以用if else来判断
     * @param array
     * @param left
     * @param right
     */
    public void quickSortByRandom(int[] array,int left,int right){
        if (right<=left||left<0||right>array.length){
            return;
        }
        Random rand=new Random();
        int randNumber =rand.nextInt(right - left + 1) + left;
        int value=array[randNumber];
        int i=left;
        int j=right;
        int temp;
        temp=array[randNumber];
        array[randNumber]=array[left];
        array[left]=temp;
        while (i<j){
            while(array[i]<=value&&i<j){
                i++;
            }
            while (array[j]>=value&&i<j){
                j--;
            }
            if (i<j){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        if (array[j]>value){
            temp=array[left];
            array[left]=array[j-1];
            array[j-1]=temp;
        }else{
            temp=array[left];
            array[left]=array[j];
            array[j]=temp;
        }
        quickSortByRandom(array,left,j-1);
        quickSortByRandom(array,j,right);
    }
    public void quickSortByThreeMiddle(int[] array,int left,int right){
        if (left>=right||left<0||right>array.length){
            return;
        }
        dealPivot(array,left,right);
        int value=array[left];
        int i=left;
        int j=right;
        int temp;
        while (i<j){
            while (array[j]>=value&&i<j){
                j--;
            }
            while(array[i]<=value&&i<j){
                i++;
            }
            temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
        array[left]=array[i];
        array[i]=value;
        quickSortByFixed(array,left,j-1);
        quickSortByFixed(array,j+1,right);
    }
    private void dealPivot(int[] arr,int left,int right){
        int middle=(left+right)/2;
        if (arr[left]>arr[middle]){
            swap(arr,left,middle);
        }
        if (arr[left]>arr[right]){
            swap(arr,left,right);
        }
        if (arr[right]<arr[middle]){
            swap(arr,right,middle);
        }
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
