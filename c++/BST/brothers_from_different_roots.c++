// Brothers From Different Roots
// https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1

void inOrder1(Node *root1, vector<int> &v1)
{
    if (root1 == NULL)
    {
        return;
    }
    inOrder1(root1->left, v1);
    v1.push_back(root1->data);
    inOrder1(root1->right, v1);
}

void inOrder2(Node *root2, vector<int> &v2)
{
    if (root2 == NULL)
    {
        return;
    }
    inOrder2(root2->left, v2);
    v2.push_back(root2->data);
    inOrder2(root2->right, v2);
}

int countPairs(Node *root1, Node *root2, int x)
{
    vector<int> v1, v2;
    inOrder1(root1, v1);
    inOrder2(root2, v2);

    int i = 0, j = v2.size() - 1, count = 0;

    while (i < v1.size() && j >= 0)
    {
        if (v1[i] + v2[j] == x)
        {
            count++;
            j--;
        }
        else if (v1[i] + v2[j] < x)
        {
            i++;
        }
        else
        {
            j--;
        }
    }
    return count;
}