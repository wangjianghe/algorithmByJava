import util.TreeNode;
import util.TreeUtil;

/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class SortCompareMain {
    public static void main(String[] args) {
        TreeNode treeNode=TreeUtil.getBinarySearchIntTree(5,0,99);
        TreeUtil.preOderTraversal(treeNode);
        System.out.println();
        TreeUtil.inOrderTraversal(treeNode);
    }
}
