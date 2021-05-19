#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }

    ~Node()
    {
        delete next;
    }
};

Node *takeInput(vector<int> &arr)
{
    Node *head = NULL, *tail = NULL;
    for (int i = 0; i < arr.size(); i++)
    {
        Node *newNode = new Node(arr[i]);
        if (head == NULL && tail == NULL)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail->next = newNode;
            tail = newNode;
        }
    }
    return head;
}

void printLL(Node *head)
{
    Node *temp = head;
    while (temp != NULL)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

int lengthLL(Node *head)
{
    if (head == NULL)
        return 0;
    return lengthLL(head->next) + 1;
}

Node *reverseLL(Node *head)
{
    if (head == NULL)
        return NULL;
    if (head->next == NULL)
        return head;
    Node *newHead = reverseLL(head->next);
    head->next->next = head;
    head->next = NULL;
    return newHead;
}

bool isPalindrome(Node *head)
{
    //write your code here
    if (head == NULL || head->next == NULL)
        return true;
    Node *slow = head;
    Node *fast = head;
    while (fast != NULL && fast->next != NULL && fast->next->next != NULL)
    {
        fast = fast->next->next;
        slow = slow->next;
    }
    Node *newHead = slow->next;
    slow->next = NULL;
    newHead = reverseLL(newHead);
    Node *firstSubList = head;
    Node *secondSubList = newHead;
    bool ans = true;
    while (secondSubList != NULL)
    {
        if (firstSubList->data != secondSubList->data)
        {
            ans = false;
            break;
        }
        firstSubList = firstSubList->next;
        secondSubList = secondSubList->next;
    }
    firstSubList = head;
    secondSubList = reverseLL(newHead);
    while (firstSubList->next != NULL)
    {
        firstSubList = firstSubList->next;
    }
    firstSubList->next = secondSubList;
    return ans;
}

int main()
{
    vector<int> arr1 = {2, 3, 5, 3, 2};
    Node *head1 = takeInput(arr1);
    printLL(head1);
    cout << (isPalindrome(head1) ? "YES" : "NO") << endl;
    vector<int> arr2 = {2, 3, 5, 5, 3, 2};
    Node *head2 = takeInput(arr2);
    printLL(head2);
    cout << (isPalindrome(head2) ? "YES" : "NO") << endl;
    vector<int> arr3 = {2, 3, 5, 7, 8, 5, 3, 2};
    Node *head3 = takeInput(arr3);
    printLL(head3);
    cout << (isPalindrome(head3) ? "YES" : "NO") << endl;
    delete head1;
    delete head2;
    delete head3;
    return 0;
}