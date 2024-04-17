package com.assignment4;

class InsertNode {
    int val;
    InsertNode prev;
    InsertNode next;

    InsertNode(int val) {
        this.val = val;
    }
}

 class InsertSortedDoublyLinkedList {
    public InsertNode insert(InsertNode head, int val) {
    	InsertNode newNode = new InsertNode(val);
        
        // If the list is empty or the value to insert is less than the head value
        if (head == null || val <= head.val) {
            newNode.next = head;
            if (head != null)
                head.prev = newNode;
            return newNode;
        }
        
        InsertNode current = head;
        
        // Traverse the list to find the appropriate position to insert the new node
        while (current.next != null && current.next.val < val) {
            current = current.next;
        }
        
        // Insert the new node after the current node
        newNode.next = current.next;
        if (current.next != null)
            current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
        
        return head;
    }

    public static void main(String[] args) {
        // Example usage
    	InsertNode head = new InsertNode(1);
        head.next = new InsertNode(3);
        head.next.prev = head;
        head.next.next = new InsertNode(5);
        head.next.next.prev = head.next;

        InsertSortedDoublyLinkedList solution = new InsertSortedDoublyLinkedList();

        // Insert a value into the sorted doubly linked list
        int valueToInsert = 4;
        head = solution.insert(head, valueToInsert);

        // Print the updated list
        InsertNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

