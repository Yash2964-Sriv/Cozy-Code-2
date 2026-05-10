
/**
 * Basic DSA - Reverse Linked List (LeetCode 206)
 * Reverse a singly linked list iteratively.
 */
#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

ListNode* reverseList(ListNode* head) {
    ListNode* prev = nullptr;
    while (head) {
        ListNode* next = head->next;
        head->next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

void printList(ListNode* head) {
    std::cout << "[";
    while (head) {
        std::cout << head->val;
        if (head->next) std::cout << ",";
        head = head->next;
    }
    std::cout << "]\n";
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Reverse Linked List\n";
    std::cout << std::string(60, '=') << "\n";

    ListNode* a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    std::cout << "[1,2,3,4,5] -> ";
    printList(reverseList(a));

    ListNode* b = new ListNode(1, new ListNode(2));
    std::cout << "[1,2] -> ";
    printList(reverseList(b));
}