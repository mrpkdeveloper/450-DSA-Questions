#include <bits/stdc++.h>
using namespace std;

void printTargetSumSubsets(vector<int> &arr, int index, string subset, int subsetSum, int target)
{
    if (index == arr.size() && subsetSum == target)
    {
        cout << subset << "." << endl;
        return;
    }
    if (arr.size() == index)
    {
        return;
    }
    if (subsetSum > target)
    {
        return;
    }
    printTargetSumSubsets(arr, index + 1, subset + to_string(arr[index]) + ", ", subsetSum + arr[index], target);
    printTargetSumSubsets(arr, index + 1, subset, subsetSum, target);
}

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int target;
    cin >> target;
    printTargetSumSubsets(arr, 0, "", 0, target);
    return 0;
}