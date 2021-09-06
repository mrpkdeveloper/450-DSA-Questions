// Flatten Binary Tree to Linked List
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution
{
public:
    void flatten(TreeNode *root)
    {
        while (root)
        {
            if (root->left && root->right)
            {
                // finding rightmost in the left subtree
                TreeNode *t = root->left;
                while (t->right)
                {
                    t = t->right;
                }
                /*right subtree of the current node will become right child of the rightmost child in the left     subtree*/
                t->right = root->right;
            }
            if (root->left)
            {
                // assign right subtree with left subtree
                root->right = root->left;
            }
            root->left = NULL;
            root = root->right;
        }
    }
};