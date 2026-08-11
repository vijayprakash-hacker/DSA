/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode dummy(0, head);

        ListNode* P1 = &dummy;
        for (int i = 1; i < k; ++i) {
            P1 = P1->next;
        }
        ListNode* N1 = P1->next;

        ListNode* fast = N1;
        ListNode* P2 = &dummy;
        while (fast->next != nullptr) {
            fast = fast->next;
            P2 = P2->next;
        }
        ListNode* N2 = P2->next;

        if (N1 == N2) return dummy.next;

        if (N1->next == N2) {
            P1->next = N2;
            N1->next = N2->next;
            N2->next = N1;
        } else if (N2->next == N1) {
            P2->next = N1;
            N2->next = N1->next;
            N1->next = N2;
        } else {
            ListNode* N1_next = N1->next;
            ListNode* N2_next = N2->next;

            P1->next = N2;
            P2->next = N1;
            N1->next = N2_next;
            N2->next = N1_next;
        }

        return dummy.next;
    }
};