//Write a program to find a unique number in an array where all numbers except one,
//are present twice.
#include <bits/stdc++.h>
using namespace std;
int unique(int arr[], int n)
{
    int xorsum = 0;
    for (int i = 0; i < n; i++)
    {
        xorsum = xorsum ^ arr[i];
    }
    return xorsum;
}
int main()
{
    int arr[] = {1, 2, 3, 4, 1, 2, 3};
    cout << unique(arr, 7) << endl;
    return 0;
}
//Output: 4 (as it is not present twice)
