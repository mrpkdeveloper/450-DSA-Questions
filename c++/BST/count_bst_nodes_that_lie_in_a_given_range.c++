// Count BST nodes that lie in a given range
// https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1

int getCount(Node *root, int l, int h)
{
    if (root == NULL)
    {
        return 0;
    }
    if (root->data >= l && root->data <= h)
    {
        return 1 + getCount(root->left, l, h) + getCount(root->right, l, h);
    }
    if (root->data < l)
    {
        return getCount(root->right, l, h);
    }
    if (root->data > h)
    {
        return getCount(root->left, l, h);
    }
}