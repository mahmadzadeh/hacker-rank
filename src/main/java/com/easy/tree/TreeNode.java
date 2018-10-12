package com.easy.tree;

public class TreeNode {
    public int value;
    public TreeNode right;
    public TreeNode left;
    public TreeNode parent;

    public TreeNode( int value, TreeNode right, TreeNode left ) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public TreeNode( int value ) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}
