#include <bits/stdc++.h>
using namespace std;

class BSTPair
{
public:
    bool isBST;
    int min;
    int max;
};

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

BSTPair isTreeBST(Node *root)
{
    if (root == NULL)
    {
        BSTPair p;
        p.isBST = true;
        p.min = INT_MAX;
        p.max = INT_MIN;
        return p;
    }
    BSTPair lp = isTreeBST(root->left);
    BSTPair rp = isTreeBST(root->right);
    BSTPair p;
    if (root->data >= lp.max && root->data <= rp.min && lp.isBST && rp.isBST)
    {
        p.isBST = true;
    }
    else
    {
        p.isBST = false;
    }
    p.min = min(root->data, min(lp.min, rp.min));
    p.max = max(root->data, max(lp.max, rp.max));
    return p;
}

int main()
{
    vector<int> arr1 = {50, 25, 75, 12, 37, 62, 87};
    vector<int> arr2 = {50, 25, 75, 12, 37, 62, 87, -1, -1, 30, 40, 70, 74, -1, -1};
    Node *root1 = takeInput(arr1);
    Node *root2 = takeInput(arr2);
    BSTPair p = isTreeBST(root1);
    cout << (p.isBST ? "YES" : "NO") << endl;
    p = isTreeBST(root2);
    cout << (p.isBST ? "YES" : "NO") << endl;
    delete root1;
    delete root2;
    return 0;
}