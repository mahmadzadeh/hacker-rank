package com.tree;

import com.easy.tree.IntBinaryTree;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;


public class IntBinaryTreeTest {

    @Test
    public void canCreateEmptyTreeNode() {

        assertEquals( 0, new IntBinaryTree().size() );
    }

    @Test
    public void addingNewNodeToEmptyTreeNodeIncreasesTheSize() {

        IntBinaryTree tree = new IntBinaryTree().insert( 1 );

        assertEquals( 1, tree.size() );
    }


    @Test
    public void addingNewNodeSmallerThanParentWillAddToLeftOfParent() {

        IntBinaryTree tree = new IntBinaryTree().insert( 10 ).insert( 5 );

        System.out.println( tree.display() );

        assertEquals( 2, tree.size() );
        assertEquals( "510", tree.display() );
    }

    @Test
    public void addingNewNodeLargerThanParentWillAddToRightOfParent() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 10 )
                .insert( 5 )
                .insert( 15 )
                .insert( 20 )
                .insert( 2 );

        assertEquals( 5, tree.size() );
        assertEquals( "25101520", tree.display() );
    }

    @Test
    public void findingNonExistentNumberReturnsOptionalNone() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 10 )
                .insert( 5 )
                .insert( 15 )
                .insert( 20 )
                .insert( 2 );

        assertEquals( Optional.empty(), tree.find( 333 ) );
    }

    @Test
    public void findingNumberThatExistInTreeReturnsOptional() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 10 )
                .insert( 5 )
                .insert( 15 )
                .insert( 20 )
                .insert( 2 );

        assertEquals( 10, tree.find( 10 ).get().value );
        assertEquals( 5, tree.find( 5 ).get().value );
        assertEquals( 2, tree.find( 2 ).get().value );
        assertEquals( 20, tree.find( 20 ).get().value );
    }

    @Test
    public void findingMinInEmptyTreeReturnsOptionalEmpty() {

        IntBinaryTree tree = new IntBinaryTree();

        assertEquals( Optional.empty(), tree.findMin() );
    }

    @Test
    public void findingMinInTreeWithOneElementReturnsThatElement() {

        IntBinaryTree tree = new IntBinaryTree().insert( 55 );

        assertEquals( Optional.of( 55 ), tree.findMin() );
    }

    @Test
    public void findingMinInTreeWithMultipleNodesReturnsAbsoluteMinInTree() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .insert( 0 )
                .insert( 100 )
                .insert( -1 )
                .insert( -22 );

        assertEquals( Optional.of( -22 ), tree.findMin() );
    }

    @Test
    public void removingNonExistentItemHasNoEffect() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .insert( 0 )
                .insert( 100 )
                .insert( -1 )
                .insert( -22 )
                .remove( 203039 );

        assertEquals( 5 , tree.size() );
    }

    @Test
    public void removingOneItemWhenTreeIsOfSizeOne() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .remove( 55 );

        assertEquals( 0, tree.size() );
        assertEquals( Optional.empty(), tree.find(55) );
    }


    @Test
    public void removingLeafNode() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .insert( 22 )
                .remove( 22 );

        assertEquals( 1, tree.size() );
        assertEquals( Optional.empty(), tree.find(22) );
        assertEquals( 55, tree.find(55).get().value );
    }

    @Test
    public void removingLeafRightNode() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .insert( 66 )
                .remove( 66 );

        assertEquals( 1, tree.size() );
        assertEquals( Optional.empty(), tree.find(66) );
        assertEquals( 55, tree.find(55).get().value );
    }

    @Test
    public void removingInternalNodeWithChilderen() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .insert( 22 )
                .insert( 66 )
                .insert( 60 )
                .remove( 55 );

        assertEquals( 3, tree.size() );
        assertEquals( 66, tree.find(66).get().value );
        assertEquals( 22, tree.find(22).get().value );
        assertEquals( 60, tree.find(60).get().value );
        assertEquals( 60, tree.getRoot().value);
    }

    @Test
    public void removingRootNodeWithRightAndLeftChild() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 55 )
                .insert( 22 )
                .insert( 66 )
                .remove( 55 );

        assertEquals( 2, tree.size() );
        assertEquals( 66, tree.find(66).get().value );
        assertEquals( 22, tree.find(22).get().value );
        assertEquals( 66, tree.getRoot().value);
    }

    /**
     * Starting with :
     *
     *             (15)
     *          /      \
     *       (10)      (16)
     *      /    \        \
     *    (8)   (11)      (19)
     *                       \
     *                       (20)
     *
     * removing the root
     *
     *            (16)
     *          /      \
     *       (10)      (19)
     *      /    \        \
     *    (8)   (11)      (20)
     *
     */
    @Test
    public void removingRootNodeWithRightAndLeftChildWhenRightChildHasChildren() {

        IntBinaryTree tree = new IntBinaryTree()
                .insert( 15 )
                .insert( 10 )
                .insert( 8 )
                .insert( 11 )
                .insert( 16 )
                .insert( 19 )
                .insert( 20 )
                .remove( 15 );

        assertEquals( 6, tree.size() );
        assertEquals( Optional.empty(), tree.find(15) );
        assertEquals( 16, tree.getRoot().value);
        assertEquals( 10, tree.find(10).get().value );
        assertEquals( 8, tree.find(8).get().value );
        assertEquals( 19, tree.find(19).get().value );
        assertEquals( 20, tree.find(20).get().value );
    }

}
