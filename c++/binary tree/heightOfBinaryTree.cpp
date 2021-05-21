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

Node *takeInputPreorder(vector<int> &arr)
{
    int index = 1;
    stack<pair<Node *, int>> s;
    Node *root = new Node(arr[0]);
    s.push(make_pair(root, 0));
    while (!s.empty())
    {
        pair<Node *, int> top = s.top();
        if (top.second == 0)
        {
            s.top().second++;
            if (arr[index] != -1)
            {
                Node *leftChild = new Node(arr[index]);
                top.first->left = leftChild;
                s.push(make_pair(leftChild, 0));
            }
            index++;
        }
        else if (top.second == 1)
        {
            s.top().second++;
            if (arr[index] != -1)
            {
                Node *rightChild = new Node(arr[index]);
                top.first->right = rightChild;
                s.push(make_pair(rightChild, 0));
            }
            index++;
        }
        else
        {
            s.pop();
        }
    }
    return root;
}

int height(Node *root)
{
    if (root == NULL)
        return -1;
    return 1 + max(height(root->left), height(root->right));
}

int main()
{
    vector<int> arr1 = {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1};
    vector<int> arr2 = {50, 25, 75, 12, 37, 62, 87, -1, -1, 30, -1, -1, 70};
    Node *root1 = takeInputPreorder(arr1);
    Node *root2 = takeInput(arr2);
    display(root2);
    cout << endl;
    cout << "HEIGHT : " << height(root2) << endl;
    delete root1;
    return 0;
}