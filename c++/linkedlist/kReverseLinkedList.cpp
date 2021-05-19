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

Node *kReverse(Node *head, int k)
{
    //Write your code here
    if (head == NULL)
        return NULL;
    if (k == 0 || k == 1)
        return head;
    Node *prevHead = NULL, *prevTail = NULL, *currHead = NULL, *currTail = NULL;
    Node *temp = head;
    while (temp != NULL)
    {
        for (int i = 0; i < k && temp != NULL; i++)
        {
            if (prevHead == NULL && prevTail == NULL)
            {
                prevHead = temp;
                prevTail = temp;
                temp = temp->next;
            }
            else
            {
                Node *newTemp = temp;
                temp = temp->next;
                newTemp->next = prevHead;
                prevHead = newTemp;
            }
        }
        if (currHead == NULL && currTail == NULL)
        {
            currHead = prevHead;
            currTail = prevTail;
        }
        else
        {
            currTail->next = prevHead;
            currTail = prevTail;
        }
        prevHead = NULL;
        prevTail = NULL;
    }
    currTail->next = NULL;
    return currHead;
}

int main()
{
    vector<int> arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Node *head1 = takeInput(arr1);
    printLL(head1);
    head1 = kReverse(head1, 4);
    printLL(head1);
    delete head1;
    return 0;
}