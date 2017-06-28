package com.qm.algorithms.algorithm623;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wodvpn on 2017/6/24.
 */
public class Solution {

    /**
     * root是否可以为null？
     * 添加规则:
     * 1.给定一个正整数深度d,对于每一个深度为d-1的非空的树节点N,创建两个树节点
     * (值为v)作为N的左子树根节点和右子树根节点.并且N的原来的左子树作为新的左子树
     * 根节点的左子树,N的原来的右子树根节点应该是新的右子树根节点的右子树.
     * 如果深度d的值为1,表示没有深度为d-1的节点,那么这时候要创建一个新的节点
     * ,值为v,作为原来的树的新的根节点,原来的树是新的根节点的左子树。
     *
     * @param root 二叉树的根节点
     * @param v    值
     * @param d    深度
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode tr = new TreeNode(v);
            tr.left = root;
            return tr;
        }
        List<TreeNode> lst = new ArrayList<>();
        lst.add(root);
        int level = 1;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode node = null;
        TreeNode temp = null;
        int size = lst.size();
        int current = 0;
        while (!lst.isEmpty() && level < d - 1) {
            node = lst.remove(0);
            if (node.left != null) {
                lst.add(node.left);
            }
            if (node.right != null) {
                lst.add(node.right);
            }
            current++;
            if(current == size){
                level++;
                size = lst.size();
                current = 0;
            }
        }

        int index = 0;
        int length = lst.size();
        while (index < length) {
            node = lst.get(index);
            temp = new TreeNode(v);
            left = node.left;
            node.left = temp;
            temp.left = left;
            temp = new TreeNode(v);
            right = node.right;
            node.right = temp;
            temp.right = right;
            index++;
        }
        return root;
    }
}
