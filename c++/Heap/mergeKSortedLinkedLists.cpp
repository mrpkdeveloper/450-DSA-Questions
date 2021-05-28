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

Node *mergeKLists(vector<Node *> &lists)
{
    if (lists.size() == 0)
        return NULL;
    Node *head = NULL, *tail = NULL;
    priority_queue<pair<int, Node *>, vector<pair<int, Node *>>, greater<pair<int, Node *>>> pq;
    for (auto i : lists)
    {
        if (i == NULL)
            continue;
        pq.push(make_pair(i->data, i));
    }
    while (!pq.empty())
    {
        Node *top = pq.top().second;
        pq.pop();
        if (head == NULL)
        {
            head = top;
            tail = top;
        }
        else
        {
            tail->next = top;
            tail = top;
        }
        if (top->next)
            pq.push(make_pair(top->next->data, top->next));
    }
    if (tail)
        tail->next = NULL;
    return head;
}

int main()
{
    int k;
    cin >> k;
    vector<Node *> lists;
    for (int i = 0; i < k; i++)
    {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int j = 0; j < n; j++)
            cin >> arr[j];
        Node *head = takeInput(arr);
        lists.push_back(head);
    }
    Node *head = mergeKLists(lists);
    printLL(head);
    return 0;
}