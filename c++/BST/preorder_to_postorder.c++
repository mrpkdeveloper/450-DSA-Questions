// Preorder to Postorder
// https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1

Node *constructTreeUtil(int pre[], int start, int end)
{
    if (start > end)
        return NULL;
    Node *root = newNode(pre[start]);
    int i;
    for (i = start + 1; i <= end; i++)
    {
        if (pre[i] > root->data)
            break;
    }
    root->left = constructTreeUtil(pre, start + 1, i - 1);
    root->right = constructTreeUtil(pre, i, end);
    return root;
}

Node *constructTree(int pre[], int size)
{
    return constructTreeUtil(pre, 0, size - 1);
}