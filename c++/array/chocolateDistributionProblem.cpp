#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int minimumChocolateDifference(int arr[], int n, int m)
{
    sort(arr, arr + n);
    int i = m - 1;
    int minDifference = INT_MAX;
    while (i < n)
    {
        if (arr[i] - arr[i - m + 1] < minDifference)
        {
            minDifference = arr[i] - arr[i - m + 1];
        }
        i++;
    }
    return minDifference;
}

int main()
{
    int t;
    cin >> t;
    for (int x = 0; x < t; x++)
    {
        int n, m;
        cin >> n;
        int *arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }
        cin >> m;
        int ans = minimumChocolateDifference(arr, n, m);
        cout << ans << endl;
        delete[] arr;
    }
    return 0;
}