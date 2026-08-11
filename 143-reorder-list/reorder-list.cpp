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
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* mid = slow;

        ListNode* curr = mid->next;
        mid->next = NULL;
        ListNode* prev = NULL;
        ListNode* next;

        while (curr) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        ListNode* left = head;
        ListNode* right = prev;
        ListNode* nextL;
        ListNode* nextR;

        while (left && right) {
            nextL = left->next;
            left->next = right;
            nextR = right->next;
            right->next = nextL;

            left = nextL;
            right = nextR;
        }
    }
};