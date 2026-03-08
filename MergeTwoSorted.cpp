/**
 * Basic DSA - Merge Two Sorted Lists (LeetCode 21)
 * Merge two sorted linked lists into one sorted list.
 */
#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    ListNode dummy(0);
    ListNode* tail = &dummy;
    while (l1 && l2) {
        if (l1->val <= l2->val) {
            tail->next = l1;
            l1 = l1->next;
        } else {
            tail->next = l2;
            l2 = l2->next;
        }
        tail = tail->next;
    }
    tail->next = l1 ? l1 : l2;
    return dummy.next;
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
    std::cout << "Problem: Merge Two Sorted Lists\n";
    std::cout << std::string(60, '=') << "\n";

    ListNode* a1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode* a2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    std::cout << "[1,2,4] + [1,3,4] -> ";
    printList(mergeTwoLists(a1, a2));

    std::cout << "[] + [] -> ";
    printList(mergeTwoLists(nullptr, nullptr));

    ListNode* b1 = nullptr;
    ListNode* b2 = new ListNode(0);
    std::cout << "[] + [0] -> ";
    printList(mergeTwoLists(b1, b2));
}