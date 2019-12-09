package util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年12月09日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class TreeUtil {
    //二叉搜索树
    public static TreeNode<Integer> getBinarySearchIntTree(int size,int left,int right) {
        if (size == 0) {
            return null;
        }
        ArrayList<TreeNode<Integer>> list = new ArrayList<>();
        TreeNode<Integer> treeNode = null;
        int[] sortArray = CommonUtil.getRandomArray(size, left, right);
        Arrays.sort(sortArray);
        return arrayToTree(sortArray, 0, sortArray.length - 1);
    }
    private static TreeNode<Integer> arrayToTree(int[] arr, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode<Integer> node = new TreeNode<Integer>(arr[mid]);
            node.left = arrayToTree(arr, left, mid - 1);
            node.right = arrayToTree(arr, mid + 1, right);
            return node;
        } else {
            return null;
        }
    }
    public static void preOderTraversal(TreeNode treeNode){
        if (treeNode!=null){
            System.out.print(treeNode.val+" ");
            preOderTraversal(treeNode.left);
            preOderTraversal(treeNode.right);
        }else{
            System.out.print("null ");
            return;
        }
    }
    public static void inOrderTraversal(TreeNode treeNode){
        if (treeNode!=null){
            preOderTraversal(treeNode.left);
            System.out.print(treeNode.val+" ");
            preOderTraversal(treeNode.right);
        }else{
            System.out.print("null ");
            return;
        }
    }
    public static void postOrderTraversal(TreeNode treeNode){
        if (treeNode!=null){
            preOderTraversal(treeNode.left);
            preOderTraversal(treeNode.right);
            System.out.print(treeNode.val+" ");
        }else{
            System.out.print("null ");
            return;
        }
    }
    //删除节点
    public static void deleteTreeNode(TreeNode treeNode,Integer deleteVal){

    }
    //插入一个节点
    public static void insertTreeNode(TreeNode treeNode,Integer insertVal){

    }
}
