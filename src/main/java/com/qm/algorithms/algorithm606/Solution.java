package com.qm.algorithms.algorithm606;

import org.junit.Test;

public class Solution {
    /**
     * 
     * 606. Construct String from Binary Tree
     * 
     * 
     *  [1,2,3,4]=>
     *  1()()
     *  
     *  2()
     *  
     *  4
     *  
     *  
     *  
     * 
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
    	if(t == null){
    		return "";
    	}
    	StringBuilder  s = new StringBuilder(""+t.val);
    	if(t.left == null && t.right == null){
    		return s.toString();
    	}else if(t.left == null){
    		s.append("()("+ tree2str(t.right) + ")");
    	}else if(t.right == null){
    		s.append("("+ tree2str(t.left) + ")");
    	}else{
    		s.append("("+ tree2str(t.left) + ")"+"("+ tree2str(t.right) + ")");
    	}
        return s.toString();
    }
    
    @Test
    public void test(){
    	TreeNode tn = new TreeNode(-1);
    	tn.left = new TreeNode(-2);
    	tn.left.left = new TreeNode(-3);
    	tn.left.left.left  = new TreeNode(-4);
    	System.out.println(tree2str(tn));
    }
}