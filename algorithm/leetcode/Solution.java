package leetcode;

import util.TreeNode;
import util.TreeUtil;

/**
 *<p>Description:${Description}</p>
 *<p>Create Date:2020年01月02日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Integer[] arr = {3, 4, 5, 1, 2};
        Integer[] arr2 = {4, 1, 2};
        TreeNode root1 = new TreeNode(arr[0]);
        TreeNode root2 = new TreeNode(arr2[0]);
        TreeUtil.arrayToTree(arr, root1, 0);
        TreeUtil.arrayToTree(arr2, root2, 0);
        Solution solution = new Solution();

    }
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        if (root.left==null){
            return minDepth(root.right)+1;
        }
        if (root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
