package TreesAndGraphs;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
//------ SOLUTION ---------

import jdk.nashorn.api.tree.Tree;


public class ValidateBST {
    Integer last_printed = null;

    /**
     * Our first thought might be to do an in-order traversal, copy the elements to an array, and then check to see
     * if the array is sorted.
     *
     * @param n : node
     * @return
     */
    boolean checkBST(TreeNode n) {
        if (n == null) return true;

        //check left
        if (!checkBST(n.left)) return false;

        //check current
        if (last_printed != null && n.value <= last_printed) {
            return false;
        }

        last_printed = n.value;

        //check right
        if (!checkBST(n.right)) return false;

        return true;
    }

    /**
     * the condition is that all left nodes must be less than or equal to the current node, which
     * must be less than all the right nodes.
     * Using this thought, we can approach the problem by passing down the min and max values. As we iterate
     * through the tree, we verify against progressively narrower ranges.
     *
     * @param n : node
     * @return
     */
    boolean checkBST1(TreeNode n) {
        return checkBST1(n, null, null);
    }

    boolean checkBST1(TreeNode n, Integer min, Integer max) {
        if (n == null) return true;

        if ((min != null && n.value <= min) || (max != null && n.value > max)) {
            return false;
        }

        if (!checkBST1(n.left, min, n.value) || !checkBST1(n.right, n.value, max)) {
            return false;
        }
        return true;
    }
}
