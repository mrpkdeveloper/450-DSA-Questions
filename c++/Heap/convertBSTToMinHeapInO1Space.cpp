#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;

    Node(int data)
    {
        this->data = data;
        this->left = NULL;
        this->right = NULL;
    }

    ~Node()
    {
        delete left;
        delete right;
    }
};

void display(Node *root)
{
    if (root == NULL)
        return;
    if (root->left)
    {
        cout << root->left->data << " - ";
    }
    else
    {
        cout << ". - ";
    }
    cout << root->data << " - ";
    if (root->right)
    {
        cout << root->right->data << endl;
    }
    else
    {
        cout << "." << endl;
    }
    display(root->left);
    display(root->right);
}

Node *takeInput(vector<int> &arr)
{
    queue<Node *> q;
    Node *root = new Node(arr[0]);
    q.push(root);
    int index = 1;
    while (!q.empty())
    {
        Node *front = q.front();
        q.pop();
        if (arr[index] != -1)
        {
            front->left = new Node(arr[index]);
            q.push(front->left);
        }
        index++;
        if (index == arr.size())
            break;
        if (arr[index] != -1)
        {
            front->right = new Node(arr[index]);
            q.push(front->right);
        }
        index++;
        if (index == arr.size())
            break;
    }
    return root;
}

void levelorderLinewise(Node *root)
{
    queue<pair<Node *, int>> q;
    q.push(make_pair(root, 0));
    int level = 0;
    while (!q.empty())
    {
        pair<Node *, int> front = q.front();
        q.pop();
        if (front.second > level)
        {
            cout << endl;
            level = front.second;
        }
        cout << front.first->data << " ";
        if (front.first->left)
            q.push(make_pair(front.first->left, front.second + 1));
        if (front.first->right)
            q.push(make_pair(front.first->right, front.second + 1));
    }
    cout << endl;
}

void BSTToSortedLL(Node *root, Node *&head)
{
    if (root == NULL)
        return;
    BSTToSortedLL(root->right, head);
    root->right = head;
    Node *temp = root->left;
    root->left = NULL;
    head = root;
    BSTToSortedLL(temp, head);
}

Node *SortedLLToMinHeap(Node *head)
{
    if (head == NULL)
        return NULL;
    queue<Node *> q;
    Node *root = head;
    head = head->right;
    root->right = NULL;
    q.push(root);
    while (!q.empty())
    {
        Node *parent = q.front();
        q.pop();
        if (head)
        {
            Node *leftChild = head;
            head = head->right;
            leftChild->right = NULL;
            parent->left = leftChild;
            q.push(leftChild);
        }
        if (head)
        {
            Node *rightChild = head;
            head = head->right;
            rightChild->right = NULL;
            parent->right = rightChild;
            q.push(rightChild);
        }
    }
    return root;
}

void convertBSTToMinHeap(Node *&root)
{
    Node *head = NULL;
    BSTToSortedLL(root, head);
    root = SortedLLToMinHeap(head);
}

int main()
{
    vector<int> arr1 = {8, 4, 12, 2, 6, 10, 14};
    Node *root1 = takeInput(arr1);
    convertBSTToMinHeap(root1);
    display(root1);
    levelorderLinewise(root1);
    delete root1;
    return 0;
}