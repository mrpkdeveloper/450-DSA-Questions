//Problem Link - https://leetcode.com/problems/intersection-of-two-linked-lists/

//Code :-

class Solution {
public:    
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        ListNode *temp1 = headA, *temp2 = headB;
        
        while(temp1 != temp2){
            temp1 = (temp1 == NULL) ? headB : temp1->next;
            temp2 = (temp2 == NULL) ? headA : temp2->next;
        }
        
        return temp1;
    }
};