//Problem Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

//Code :-

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n){

        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode *fast, *slow;
        fast = slow = dummy;

        while(n--){
            fast = fast->next;
        }

        while(fast->next){
            slow = slow->next;
            fast = fast->next;
        }

        if(slow->next == head){
            ListNode* delNode = slow->next;
            head = head->next;
            delete(delNode);
            return head;
        }

        ListNode* delNode = slow->next;
        slow->next = delNode->next;
        delete(delNode);

        return head;
    }
};