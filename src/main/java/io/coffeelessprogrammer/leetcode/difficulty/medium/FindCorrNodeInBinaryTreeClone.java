package io.coffeelessprogrammer.leetcode.difficulty.medium;

import io.coffeelessprogrammer.leetcode.datastructures.BinaryTreeNode;

/*
 * Problem: 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * Acceptance Rate: 84.8%
 * URL: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 *
 * Runtime: 2 ms, faster than 64.30% of Java online submissions for Find a Corresponding Node of a Binary Tree
 * in a Clone of That Tree.
 * Memory Usage: 46.8 MB, less than 47.71% of Java online submissions for Find a Corresponding Node of a Binary Tree
 * in a Clone of That Tree.
 */

public class FindCorrNodeInBinaryTreeClone {
    // private static int depth;
    private static int searchingFor;

    static {
        // depth = 0;
        searchingFor = -1;
    }

    public static BinaryTreeNode getTargetCopy(final BinaryTreeNode originalRoot, final BinaryTreeNode clonedRoot, final BinaryTreeNode target) {
        // depth = 0;
        searchingFor = target.val;

        return traverse(clonedRoot);
    }

    private static BinaryTreeNode traverse(final BinaryTreeNode currentNode) {
        if(currentNode == null) return null;
        if(currentNode.val == searchingFor) return currentNode;

        // ++depth;

        final BinaryTreeNode left = traverse(currentNode.left);
        final BinaryTreeNode right = traverse(currentNode.right);

        if(left != null && left.val == searchingFor) {
            return left;
        } else if(right != null && right.val == searchingFor) {
            return right;
        }

        // --depth;

        return null;
    }
}
