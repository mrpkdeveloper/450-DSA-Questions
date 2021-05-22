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

bool isHeap(Node *tree)
{
    // code here
    if (tree == NULL)
        return true;
    if (tree->left && (tree->left->left || tree->left->right) && !tree->right)
        return false;
    if (tree->right && (tree->right->right || tree->right->left) && !tree->left)
        return false;
    if (tree->left && tree->data < tree->left->data)
        return false;
    if (tree->right && tree->data < tree->right->data)
        return false;
    return isHeap(tree->left) && isHeap(tree->right);
}

int main()
{
    vector<int> arr1 = {100, 50, 75, 12, 37, 62, 72};
    vector<int> arr2 = {10, 20, 30, 40, 60};
    Node *root1 = takeInput(arr1);
    Node *root2 = takeInput(arr2);
    cout << (isHeap(root1) ? "YES" : "NO") << endl;
    cout << (isHeap(root2) ? "YES" : "NO") << endl;
    delete root1;
    delete root2;
    return 0;
}