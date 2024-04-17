package com.assignment4;

class SearchNode {
    int val;
    SearchNode left;
    SearchNode right;

    SearchNode(int val) {
        this.val = val;
    }
}

 class BinaryTreeSearch {
    public boolean search(SearchNode root, int target) {
        // Base case: If the root is null, return false
        if (root == null) {
            return false;
        }

        // If the target is found at the root, return true
        if (root.val == target) {
            return true;
        }

        // Recursively search in the left and right subtrees
        return search(root.left, target) || search(root.right, target);
    }

    public static void main(String[] args) {
        // Example usage
    	SearchNode root = new SearchNode(4);
        root.left = new SearchNode(2);
        root.right = new SearchNode(5);
        root.left.left = new SearchNode(1);
        root.left.right = new SearchNode(3);

        int target = 3;

        BinaryTreeSearch solution = new BinaryTreeSearch();

        // Search for the target node in the binary tree
        boolean isFound = solution.search(root, target);
        if (isFound) {
            System.out.println("Node with value " + target + " found in the binary tree.");
        } else {
            System.out.println("Node with value " + target + " not found in the binary tree.");
        }
    }
}
