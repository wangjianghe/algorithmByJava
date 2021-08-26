package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * 4数之和等于target
 */
public class Code_18 {
    public List<List<Integer>> fourSum(int[] nums, int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    break;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum2(int[] nums, int target){
        List<List<Integer>> lists=new ArrayList<>();
        int len=nums.length;
        if (len<4){
            return lists;
        }
        Arrays.sort(nums);
        for (int a=0;a<nums.length-3;a++){
            if (a>0&&nums[a]==nums[a-1]){
                continue;
            }
            int max=nums[a]+nums[len-1]+nums[len-2]+nums[len-3];
            if (max<target){
                continue;
            }
            int min=nums[a]+nums[a+1]+nums[a+2]+nums[a+3];
            if (min>target){
                break;
            }
            for (int b=a+1;b<len-2;b++){
                if (b>a+1&&nums[b]==nums[b-1]){
                    continue;
                }
                int maxb=nums[a]+nums[b]+nums[len-1]+nums[len-2];
                if (maxb<target){
                    continue;
                }
                int minb=nums[a]+nums[b]+nums[b+1]+nums[b+2];
                if (minb>target){
                    break;
                }
                int c=b+1;
                int d=len-1;
                while (c<d){
                    int value=nums[a]+nums[b]+nums[c]+nums[d];
                    if (value==target){
                        List<Integer> valueList=new ArrayList<>();
                        valueList.add(nums[a]);
                        valueList.add(nums[b]);
                        valueList.add(nums[c]);
                        valueList.add(nums[d]);
                        lists.add(valueList);
                        c++;
                        while (c<d&&nums[c]==nums[c-1]){
                            c++;
                        }
                        d--;
                        while (c<d&&nums[d]==nums[d+1]){
                            d--;
                        }
                    }else if (value>target){
                        d--;
                    }else{
                        c++;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Code_18 code_18=new Code_18();
        System.out.println(code_18.fourSum2(new int[]{-1,-5,-5,-3,2,5,0,4},-7));;
    }
}
