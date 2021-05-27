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

Node *evenAfterOdd(Node *head)
{
    Node *temp = head;
    Node *evenHead = NULL, *evenTail = NULL, *oddHead = NULL, *oddTail = NULL;
    while (temp != NULL)
    {
        if (temp->data % 2 == 0)
        {
            if (evenHead == NULL && evenTail == NULL)
            {
                evenHead = temp;
                evenTail = temp;
            }
            else
            {
                evenTail->next = temp;
                evenTail = temp;
            }
        }
        else
        {
            if (oddHead == NULL && oddTail == NULL)
            {
                oddHead = temp;
                oddTail = temp;
            }
            else
            {
                oddTail->next = temp;
                oddTail = temp;
            }
        }
        temp = temp->next;
    }
    if (evenHead && oddHead)
    {
        oddTail->next = evenHead;
        evenTail->next = NULL;
        return oddHead;
    }
    else if (evenHead)
    {
        evenTail->next = NULL;
        return evenHead;
    }
    else
    {
        oddTail->next = NULL;
        return oddHead;
    }
}

int main()
{
    vector<int> arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Node *head1 = takeInput(arr1);
    printLL(head1);
    head1 = evenAfterOdd(head1);
    printLL(head1);
    delete head1;
    return 0;
}