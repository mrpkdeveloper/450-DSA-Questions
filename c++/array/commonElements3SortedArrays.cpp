#include <iostream>
#include <vector>
using namespace std;

vector<int> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
{
    //code here.
    int i = 0, j = 0, k = 0;
    vector<int> ans;
    if (n1 == 0 || n2 == 0 || n3 == 0)
    {
        return ans;
    }
    for (int i = 0; i < n1; i++)
    {
        while (j < n2 && B[j] < A[i])
        {
            j++;
        }
        while (k < n3 && C[k] < A[i])
        {
            k++;
        }
        if (j < n2 && k < n3 && A[i] == B[j] && B[j] == C[k])
        {
            if (i == 0 || A[i] != A[i - 1])
            {
                ans.push_back(A[i]);
            }
            j++;
            k++;
        }
    }
    return ans;
}

int main()
{
    int A[7] = {1, 5, 10, 20, 20, 40, 80};
    int B[6] = {6, 7, 20, 20, 80, 100};
    int C[9] = {3, 4, 15, 20, 20, 30, 70, 80, 120};
    vector<int> ans = commonElements(A, B, C, 7, 6, 9);
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }
    return 0;
}