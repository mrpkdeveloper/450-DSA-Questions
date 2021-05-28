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

Node *constructBST(vector<int> &arr, int min, int max)
{
    if (arr.size() == 0)
        return NULL;
    if (arr[0] >= max || arr[0] < min)
        return NULL;
    Node *root = new Node(arr[0]);
    arr.erase(arr.begin());
    if (arr.size() != 0)
    {
        root->left = constructBST(arr, min, root->data);
    }
    if (arr.size() != 0)
    {
        root->right = constructBST(arr, root->data, max);
    }
    return root;
}

int main()
{
    vector<int> arr1 = {8, 5, 1, 7, 10, 12};
    vector<int> arr2 = {10, 5, 1, 7, 40, 50};
    Node *root1 = constructBST(arr1, INT_MIN, INT_MAX);
    levelorderLinewise(root1);
    display(root1);
    root1 = constructBST(arr2, INT_MIN, INT_MAX);
    levelorderLinewise(root1);
    display(root1);
    delete root1;
    return 0;
}