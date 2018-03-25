package com;

import java.util.Optional;

public class IntBinaryTree {

    private TreeNode root;
    private int size = 0;

    public IntBinaryTree() {
        this.root = null;
    }

    public int size() {
        return size;
    }

    public IntBinaryTree insert( int n ) {
        size++;
        return insertNode( root, new TreeNode( n ) );
    }

    public String display() {
        return printAllNodes( this.root );
    }

    public Optional<TreeNode> find( int i ) {
        return findIt( root, i );
    }

    public Optional<Integer> findMin() {
        if ( size == 0 ) {
            return Optional.empty();
        } else {
            return traverseLeft( root );
        }
    }

    public IntBinaryTree remove( int i ) {
        return removeIt( i );
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Helper Methods
     */

    private IntBinaryTree removeIt( int i ) {
        find( i )
                .ifPresent( n -> {
                    if ( hasNoChilderen( n ) ) {
                        if ( n == root ) {
                            root = null;
                        }
                        else if ( leftChildOfParent( n ) ) {
                            n.parent.left = null;
                        } else {
                            n.parent.right = null;
                        }
                    } else if ( hasOneChild( n ) ) {
                        copyChildAndDeleteChildNode( n );
                    } else {
                        TreeNode leftMostNodeInSubTree = findLeftMostNodeInSubTree( n.right );
                        n.value = leftMostNodeInSubTree.value;
                        if ( hasRightChild( leftMostNodeInSubTree ) ) {
                            leftMostNodeInSubTree.value = leftMostNodeInSubTree.right.value;
                            leftMostNodeInSubTree.right = null;
                        } else if ( hasNoChilderen( leftMostNodeInSubTree )) {
                            leftMostNodeInSubTree.parent.left = null;
                            leftMostNodeInSubTree.parent = null;
                        }
                    }
                    size--;
                } );

        return this;
    }

    private boolean hasRightChild( TreeNode node ) {
        return node.right != null;
    }

    private void copyChildAndDeleteChildNode( TreeNode n ) {
        if ( n.left != null ) {
            n.left = null;
            n.value = n.left.value;
        } else {
            n.right = null;
            n.value = n.right.value;
        }
    }

    private boolean hasOneChild( TreeNode n ) {
        return ( n.left == null && n.right != null ) ||
                ( n.right == null && n.left != null );
    }

    private boolean leftChildOfParent( TreeNode n ) {
        return n.parent.left == n;
    }

    private boolean hasNoChilderen( TreeNode node ) {
        return node.left == null && node.right == null;
    }

    private TreeNode findLeftMostNodeInSubTree( TreeNode node ) {

        if ( node == null || node.left == null ) {
            return node;
        } else {
            return findLeftMostNodeInSubTree( node.left );
        }
    }

    private Optional<TreeNode> findIt( TreeNode treeNode, int i ) {

        if ( treeNode == null ) {
            return Optional.empty();
        } else {
            if ( treeNode.value == i ) {
                return Optional.of( treeNode );
            } else {
                Optional<TreeNode> left = findIt( treeNode.left, i );
                if ( left.isPresent() )
                    return left;
                Optional<TreeNode> right = findIt( treeNode.right, i );
                if ( right.isPresent() )
                    return right;

                return Optional.empty();
            }
        }
    }

    private IntBinaryTree insertNode( TreeNode parent, TreeNode treeNode ) {

        if ( root == null ) {
            root = treeNode;
            root.parent = null;
        } else if ( treeNode.value < parent.value ) {
            if ( parent.left == null ) {
                parent.left = treeNode;
                treeNode.parent = parent;
            } else {
                insertNode( parent.left, treeNode );
            }
        } else if ( treeNode.value > parent.value ) {
            if ( parent.right == null ) {
                parent.right = treeNode;
                treeNode.parent = parent;
            } else {
                insertNode( parent.right, treeNode );
            }
        }

        return this;
    }

    private Optional<Integer> traverseLeft( TreeNode node ) {
        if ( node.left == null )
            return Optional.of( node.value );
        else
            return traverseLeft( node.left );
    }

    private String printAllNodes( TreeNode node ) {

        if ( node == null ) {
            return "";
        } else {
            return printAllNodes( node.left ) +
                    node.value +
                    printAllNodes( node.right );
        }
    }
}
