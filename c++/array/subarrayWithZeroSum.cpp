#include <iostream>
#include <unordered_map>
using namespace std;

bool subArrayWithZeroSum(int arr[], int n)
{
    unordered_map<int, int> arrMap;
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == 0)
        {
            return true;
        }
        sum += arr[i];
        if (arrMap.count(sum) == 1 || sum == 0)
        {
            return true;
        }
        arrMap[sum] = 1;
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
    int ans = subArrayWithZeroSum(arr, n);
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