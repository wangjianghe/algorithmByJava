package util;

import lombok.Data;

/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年12月09日</p>
 *@author:wangjianghe
 *@version 1.0
 */
@Data
public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T val;
    public TreeNode() {
    }
    public TreeNode(T val) {
        this.val = val;
    }
}
