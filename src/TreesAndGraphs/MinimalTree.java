package TreesAndGraphs;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 */

// ---- SOLUTION ------

import jdk.nashorn.api.tree.Tree;

/**
 * A minimal binary tree has about the same number of nodes on the left of each node as
 * on the right.
 * <p>
 * The algorithm is as follows:
 * 1. Insert into the tree the middle element of the array.
 * 2. Insert (into the left subtree) the left subarray elements.
 * 3. Insert (into the right subtree) the right subarray elements.
 * 4. Recurse.
 */
public class MinimalTree {

    private static int[] arr = {8, 10, 15, 19, 23, 27, 56};

    public static void main(String[] args) {
        printTree(createMinimalBST(arr));
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            printTree(root.left);
            printTree(root.right);
        }

    }

    static TreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
