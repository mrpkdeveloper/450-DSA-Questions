#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool find3Numbers(int arr[], int n, int k)
{
    sort(arr, arr + n);
    for (int a = 0; a < n; a++)
    {
        int i = 0, j = n - 1;
        int requiredSum = k - arr[a];
        while (i < j)
        {
            if (i == a)
            {
                i++;
            }
            if (j == a)
            {
                j--;
            }
            if (arr[i] + arr[j] == requiredSum)
            {
                return true;
            }
            else if (arr[i] + arr[j] > requiredSum)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
    }
    return false;
}

int main()
{
    int n;
    cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int k;
    cin >> k;
    bool ans = find3Numbers(arr, n, k);
    if (ans == 0)
    {
        cout << "FALSE" << endl;
    }
    else
    {
        cout << "TRUE" << endl;
    }
    delete[] arr;
    return 0;
}