package com.assignment4;

class ListNode1 {
    int val;
    ListNode1 prev;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
    }
}

 class DeleteNodeDoublyLinkedList {
    public ListNode1 deleteNode(ListNode1 head, ListNode1 nodeToDelete) {
        // Base case: If the list is empty or the node to delete is null, return head
        if (head == null || nodeToDelete == null) {
            return head;
        }

        // If the node to delete is the head node
        if (head == nodeToDelete) {
            head = nodeToDelete.next;
        }

        // Change next only if the node to delete is NOT the last node
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }

        // Change prev only if the node to delete is NOT the first node
        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        }

        // Clean up references from nodeToDelete
        nodeToDelete.prev = null;
        nodeToDelete.next = null;

        return head;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode1 head = new ListNode1(1);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(3);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;

        DeleteNodeDoublyLinkedList solution = new DeleteNodeDoublyLinkedList();

        // Delete node 2
        ListNode1 newHead = solution.deleteNode(head, node2);

        // Print the updated list
        ListNode1 current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
