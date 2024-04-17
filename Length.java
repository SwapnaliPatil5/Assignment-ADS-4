package com.assignment4;

class Length {
    int val;
    Length prev;
    Length next;

    Length(int val) {
        this.val = val;
    }
}

 class DoublyLinkedListLength {
    public int findLength(Length head) {
        int length = 0;
        Length current = head;
        
        // Traverse the list and count nodes until reaching null
        while (current != null) {
            length++;
            current = current.next;
        }
        
        return length;
    }

    public static void main(String[] args) {
        // Example usage
    	Length head = new Length(1);
    	Length node2 = new Length(2);
    	Length node3 = new Length(3);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;

        DoublyLinkedListLength solution = new DoublyLinkedListLength();

        // Find the length of the list
        int length = solution.findLength(head);
        System.out.println("Length of the doubly linked list: " + length);
    }
}
