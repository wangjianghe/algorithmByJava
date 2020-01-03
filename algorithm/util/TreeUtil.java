package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年12月09日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class TreeUtil {
    //二叉搜索树
    public static TreeNode getBinarySearchIntTree(int size,int left,int right,int[] arr) {
        if (size == 0) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode treeNode = null;
        int[] sortArray;
        if (arr==null){
            sortArray= CommonUtil.getRandomArray(size, left, right);
        }else{
            sortArray=arr;
        }
        Arrays.sort(sortArray);
        return arrayToTree(sortArray, 0, sortArray.length - 1);
    }
    private static TreeNode arrayToTree(int[] arr, int left, int right) {
        if (left <= right) {
            int mid = (right + left) / 2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = arrayToTree(arr, left, mid - 1);
            node.right = arrayToTree(arr, mid + 1, right);
            return node;
        } else {
            return null;
        }
    }
    //前序遍历
    public static void preOderTraversal(TreeNode treeNode){
        if (treeNode.left==null&&treeNode.right==null){
            return;
        }else if (treeNode.left==null){
            System.out.print("null "+treeNode.right.val+" ");
        }else if (treeNode.right==null){
            System.out.print(treeNode.left.val+" "+"null"+" ");
        }else{
            System.out.print(treeNode.left.val+" "+treeNode.right.val+" ");
        }
        if (treeNode.left!=null){
            preOderTraversal(treeNode.left);
        }
        if (treeNode.right!=null){
            preOderTraversal(treeNode.right);
        }
    }
    //中序遍历
    public static void inOrderTraversal(TreeNode treeNode){
        if (treeNode!=null){
            inOrderTraversal(treeNode.left);
            System.out.print(treeNode.val+" ");
            inOrderTraversal(treeNode.right);
        }else{
            System.out.print("null ");
            return;
        }
    }
    //后序遍历
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
    //层次遍历
    public static void layerTraversal(TreeNode treeNode){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.print(node.val+" ");
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
    }
    //删除节点
    public static boolean deleteTreeNode(TreeNode root,int deleteVal){
        TreeNode current=root;
        TreeNode parent=root;
        boolean isLeft=true;
        while (deleteVal!=current.val){
            if (deleteVal<=current.val){
                isLeft=true;
                if (current.left!=null){
                    parent=current;
                    current=current.left;
                }else{
                    return false;
                }
            }else{
                isLeft=false;
                if (current.right!=null){
                    parent=current;
                    current=current.right;
                }else{
                    return false;
                }
            }
        }
        //如果是根节点或者叶子节点时
        if (current.left!=null&&current.right!=null){
            if (current==root){
                root=null;
            }else if(isLeft){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }else if (current.left==null){
            if (current==root){
                root=root.right;
            }else if(isLeft){
                parent.left=current.right;
            }else{
                parent.right=current.right;
            }
        }else if (current.right==null){
            if (current==root){
                root=root.right;
            }else if (isLeft){
                parent.left=current.left;
            }else{
                parent.right=current.left;
            }
        }else{
            TreeNode successor=getSuccessor(current);
            if (current==root){
                root=successor;
            }else if (current==parent.left){
                parent.left=successor;
            }else{
                parent.right=successor;
            }
            successor.left=current.left;
        }
        return false;
    }
    //找出后继节点代替被删除节点，并且整理顺序
    public static  TreeNode getSuccessor(TreeNode delNode){
        TreeNode curr=delNode.right;
        TreeNode successor=curr;
        TreeNode sucParent=null;
        //找到后继节点
        while (curr!=null){
            sucParent=successor;
            successor=curr;
            curr=curr.left;
        }
        if (successor!=delNode.right){
            //将后继节点的右节点给原来的父节点的左节点, 因为父节点的左节点时原来的后继节点
            sucParent.left=successor.right;
            //将后继节点的右节点设置为删除节点的右节点
            successor.right=delNode.right;
        }
        return successor;
    }
    //插入一个节点
    public static TreeNode insertTreeNode(TreeNode root,Integer insertVal){
        TreeNode insertNode=new TreeNode(insertVal);
        if (root==null){
            root=new TreeNode(insertVal);
            return root;
        }
        TreeNode current=root;
        while(current!=null){
            if (insertVal>current.val){
                if(current.right==null){
                    current.right=insertNode;
                    return root;
                }else{
                    current=current.right;
                }
            }else{
                if (current.left==null){
                    current.left=insertNode;
                    return root;
                }else{
                    current=current.left;
                }
            }
        }
        return null;
    }
    //查找二叉搜索树的值
    public static TreeNode searchTreeNode(TreeNode root,Integer val){
        TreeNode current=root;
        while (!current.equals(val)){
            if (val>current.val){
                current=current.right;
            }else{
                current=current.left;
            }
            if (current==null){
                return null;
            }
        }
        return current;
    }
    public static TreeNode arrayToTree(Integer[] arr,TreeNode root,int index){
        System.out.println(root.val);
        if (2*index+1>arr.length-1){
            return root;
        }
        if (arr[2*index+1]==null){
            root.left=null;
        }else{
            TreeNode left=new TreeNode(arr[2*index+1]);
            root.left=left;
            arrayToTree(arr,left,2*index+1);
        }
        if (2*index+2>arr.length-1){
            return root;
        }
        if(arr[2*index+2]==null){
            root.right=null;
        }else{
            TreeNode right=new TreeNode(arr[2*index+2]);
            root.right=right;
            arrayToTree(arr,right,2*index+2);
        }
        return root;
    }
}
