/**
 * Basic DSA Problems - One Fundamental Linked List Question
 * Simple and essential DSA problem for beginners
 */
public class ReverseLinkeList {
    
    // Problem 1: Reverse Linked List
    // Given the head of a singly linked list, reverse the list, and return the reversed list.
    //
    // Example:
    // 1 -> 2 -> 3 -> null  becomes  3 -> 2 -> 1 -> null
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    /**
     * Iterative reversal
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    private static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }
    
    private static String toString(ListNode head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            sb.append(cur.next == null ? " -> null" : " -> ");
            cur = cur.next;
        }
        return sb.toString();
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Reverse Linked List");
        System.out.println("=".repeat(60));
        
        int[] a1 = {1, 2, 3, 4, 5};
        ListNode l1 = fromArray(a1);
        System.out.println("Before: " + toString(l1));
        ListNode r1 = reverseList(l1);
        System.out.println("After : " + toString(r1));
        
        int[] a2 = {1};
        ListNode l2 = fromArray(a2);
        System.out.println("\nBefore: " + toString(l2));
        System.out.println("After : " + toString(reverseList(l2)));
        
        int[] a3 = {};
        ListNode l3 = fromArray(a3);
        System.out.println("\nBefore: " + toString(l3));
        System.out.println("After : " + toString(reverseList(l3)));
        
        System.out.println("\nBefore: null");
        System.out.println("After : " + toString(reverseList(null)));
    }
}