package com.qm.algorithms.algorithm617;

/**
 * Created by wodvpn on 2017/6/24.
 */
public class Solution {



    /**
     * 给定两个二叉树
     * 你需要放一个到另一个上面,两颗树的一些节点将会重叠而另外一些节点不会.
     * 你需要把他们合并进一颗心的二叉树
     * 合并的规则是,如果两个节点重叠,那么两个节点的值相加的结果作为新的节点的
     * 值.否则,非空节点的值的作为新节点的值.
     *
     * @param t1
     * @param t2
     * @return
     *
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        int val = t1.val + t2.val;
        TreeNode t = new TreeNode(val);
        t.left = mergeTrees(t1.left,t2.left);
        t.right = mergeTrees(t1.right,t2.right);
        return t;
    }
}
