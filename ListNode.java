package com.assignment4;

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

 class ReverseDoublyLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode temp = null;

        // Swap next and prev for all nodes of doubly linked list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node
        }

        // Check if the list is empty or has only one node
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.prev = head;
        head.next.next = new ListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode(4);
        head.next.next.next.prev = head.next.next;

        ReverseDoublyLinkedList solution = new ReverseDoublyLinkedList();
        ListNode reversedList = solution.reverseList(head);

        // Print the reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
}

