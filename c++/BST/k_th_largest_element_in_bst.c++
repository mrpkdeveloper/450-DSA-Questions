// Kth largest element in BST
// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

int inOrder(Node *root, int &count, int k)
{
    if (root == NULL)
    {
        return -1;
    }
    int ans = inOrder(root->right, count, k);
    if (ans != -1)
    {
        return ans;
    }
    count++;
    if (count == k)
    {
        return root->data;
    }
    return inOrder(root->left, count, k);
}
int kthLargest(Node *root, int k)
{
    int count = 0;
    return inOrder(root, count, k);
}