import java.util.Arrays;
import java.util.Collections;

import util.TreeNode;
import util.TreeUtil;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class SortCompareMain {
    public static void main(String[] args) {
        int[] a={1,2,3,5,9,10,12,13,30};
        TreeNode treeNode=TreeUtil.getBinarySearchIntTree(10,0,60,null);
        TreeUtil.preOderTraversal(treeNode);
        System.out.println();
        TreeUtil.inOrderTraversal(treeNode);
        if (TreeUtil.searchTreeNode(treeNode,4)!=null){
            System.out.println();
            System.out.println("值存在");
        }else{
            TreeUtil.insertTreeNode(treeNode,4);
        }
        System.out.println();
        TreeUtil.inOrderTraversal(treeNode);
        TreeUtil.deleteTreeNode(treeNode,4);
        System.out.println();
        TreeUtil.inOrderTraversal(treeNode);

    }
}
