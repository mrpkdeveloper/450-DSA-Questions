 // Middle of the Linked List
 // Link : https://leetcode.com/problems/middle-of-the-linked-list/
 ListNode* middleNode(ListNode* head) {
        ListNode *fast=head,*slow=head;
        while(fast!=NULL && fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }