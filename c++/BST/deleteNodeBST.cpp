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

class BST
{
public:
    Node *root;

    BST()
    {
        root = NULL;
    }

    ~BST()
    {
        delete root;
    }

    bool search(int data)
    {
        return hasData(this->root, data);
    }

    void insert(int data)
    {
        this->root = insert(this->root, data);
    }

    void remove(int data)
    {
        this->root = deleteData(this->root, data);
    }

    void print()
    {
        printTree(this->root);
    }

    int size()
    {
        return size(this->root);
    }

    int sum()
    {
        return sum(this->root);
    }

    int maxVal()
    {
        return maxVal(this->root);
    }

    int minVal()
    {
        return minVal(this->root);
    }

private:
    bool hasData(Node *root, int data)
    {
        if (root == NULL)
            return false;
        return (root->data == data) || hasData(root->left, data) || hasData(root->right, data);
    }

    Node *insert(Node *root, int data)
    {
        if (root == NULL)
        {
            Node *newNode = new Node(data);
            return newNode;
        }
        if (data <= root->data)
            root->left = insert(root->left, data);
        if (data > root->data)
            root->right = insert(root->right, data);
        return root;
    }

    Node *deleteData(Node *root, int data)
    {
        if (root == NULL)
            return NULL;
        if (data < root->data)
        {
            root->left = deleteData(root->left, data);
        }
        else if (data > root->data)
        {
            root->right = deleteData(root->right, data);
        }
        else
        {
            if (root->left != NULL && root->right != NULL)
            {
                int leftMax = maxVal(root->left);
                root->data = leftMax;
                root->left = deleteData(root->left, leftMax);
                return root;
            }
            else if (root->left != NULL)
            {
                Node *temp = root->left;
                root->left = NULL;
                delete root;
                return temp;
            }
            else if (root->right != NULL)
            {
                Node *temp = root->right;
                root->right = NULL;
                delete root;
                return temp;
            }
            else
            {
                delete root;
                return NULL;
            }
        }
        return root;
    }

    void printTree(Node *root)
    {
        if (root == NULL)
            return;
        cout << root->data << ":";
        if (root->left)
            cout << "L:" << root->left->data << ",";
        if (root->right)
            cout << "R:" << root->right->data;
        cout << endl;
        printTree(root->left);
        printTree(root->right);
    }

    int size(Node *root)
    {
        if (root == NULL)
            return 0;
        return size(root->left) + size(root->right) + 1;
    }

    int sum(Node *root)
    {
        if (root == NULL)
            return 0;
        return sum(root->left) + sum(root->right) + root->data;
    }

    int maxVal(Node *root)
    {
        if (root->right != NULL)
        {
            return maxVal(root->right);
        }
        else
        {
            return root->data;
        }
    }

    int minVal(Node *root)
    {
        if (root->left != NULL)
        {
            return minVal(root->left);
        }
        else
        {
            return root->data;
        }
    }
};

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

int main()
{
    vector<int> arr1 = {50, 25, 75, 12, 37, 62, 87, -1, -1, 30, -1, -1, 70};
    Node *root1 = takeInput(arr1);
    BST *tree = new BST();
    tree->root = root1;
    cout << "SIZE: " << tree->size() << endl;
    cout << "SUM: " << tree->sum() << endl;
    cout << "MAX ELEMENT: " << tree->maxVal() << endl;
    cout << "MIN ELEMENT: " << tree->minVal() << endl;
    tree->insert(40);
    cout << "CHECKING FOR 40: " << (tree->search(40) ? "YES" : "NO") << endl;
    tree->insert(60);
    cout << "CHECKING FOR 60: " << (tree->search(60) ? "YES" : "NO") << endl;
    tree->print();
    cout << endl;
    levelorderLinewise(tree->root);
    cout << endl;
    tree->remove(40);
    cout << "CHECKING FOR 40: " << (tree->search(40) ? "YES" : "NO") << endl;
    tree->remove(60);
    cout << "CHECKING FOR 60: " << (tree->search(60) ? "YES" : "NO") << endl;
    tree->print();
    cout << endl;
    levelorderLinewise(tree->root);
    cout << endl;
    delete tree;
    return 0;
}