package com.assignment4;


class PrintHeadNode {
    int val;
    PrintHeadNode left;
    PrintHeadNode right;

    PrintHeadNode(int val) {
        this.val = val;
    }
}

 class PrintHeadNodesBinaryTree {
    public void printHeadNodes(PrintHeadNode root) {
        printHeadNode(root, root);
    }

    private void printHeadNode(PrintHeadNode current, PrintHeadNode head) {
        if (current != null) {
            System.out.println("Head node of subtree rooted at " + current.val + " is " + head.val);
            printHeadNode(current.left, current);
            printHeadNode(current.right, current);
        }
    }

    public static void main(String[] args) {
        // Example usage
    	PrintHeadNode root = new PrintHeadNode(1);
        root.left = new PrintHeadNode(2);
        root.right = new PrintHeadNode(3);
        root.left.left = new PrintHeadNode(4);
        root.left.right = new PrintHeadNode(5);
        root.right.left = new PrintHeadNode(6);
        root.right.right = new PrintHeadNode(7);

        PrintHeadNodesBinaryTree solution = new PrintHeadNodesBinaryTree();

        // Print head nodes of every node in the binary tree
        solution.printHeadNodes(root);
    }
}
