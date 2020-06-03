package util;

import lombok.Data;

/**
 *<p>Description:${Description}</p>

 *<p>Create Date:2019年12月09日</p>
 *@author:wangjianghe
 *@version 1.0
 */
@Data
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(){
    }
    public TreeNode(Integer val) {
        this.val = val;
    }
}
