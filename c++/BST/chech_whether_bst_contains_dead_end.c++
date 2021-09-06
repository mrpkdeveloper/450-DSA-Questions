// Check whether BST contains Dead End
// https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1

bool findDeadEnd(Node *root, int min, int max)
{
    if (root == NULL)
    {
        return false;
    }

    if (max - min == 2)
    {
        return true;
    }
    return (findDeadEnd(root->left, min, root->data) ||
            findDeadEnd(root->right, root->data, max));
}

bool isDeadEnd(Node *root)
{
    return findDeadEnd(root, 0, INT_MAX);
}