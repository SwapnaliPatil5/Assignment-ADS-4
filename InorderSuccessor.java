package com.assignment4;


class InorderSuccessor {
    int val;
    InorderSuccessor left;
    InorderSuccessor right;

    InorderSuccessor(int val) {
        this.val = val;
    }
}

 class InorderSuccessorBinaryTree {
    public InorderSuccessor inorderSuccessor(InorderSuccessor root, InorderSuccessor node) {
        if (node.right != null) {
            // Case 1: If the node has a right child, find the leftmost node in its right subtree
        	InorderSuccessor current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            // Case 2: If the node does not have a right child
        	InorderSuccessor successor = null;
        	InorderSuccessor ancestor = root;
            while (ancestor != node) {
                if (node.val < ancestor.val) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }

    public static void main(String[] args) {
        // Example usage
    	InorderSuccessor root = new InorderSuccessor(20);
        root.left = new InorderSuccessor(10);
        root.right = new InorderSuccessor(30);
        root.left.left = new InorderSuccessor(5);
        root.left.right = new InorderSuccessor(15);
        root.right.left = new InorderSuccessor(25);
        root.right.right = new InorderSuccessor(35);

        InorderSuccessorBinaryTree solution = new InorderSuccessorBinaryTree();

        // Find the inorder successor of a node
        InorderSuccessor node = root.left.right;
        InorderSuccessor successor = solution.inorderSuccessor(root, node);

        if (successor != null) {
            System.out.println("Inorder successor of node with value " + node.val + " is node with value " + successor.val);
        } else {
            System.out.println("Inorder successor of node with value " + node.val + " does not exist.");
        }
    }
}
