#include <iostream>
using namespace std;

int minimumLengthSubarray(int arr[], int n, int x)
{
    int start = 0, sum = 0, i, minLength = INT_MAX;
    for (i = 0; i < n; i++)
    {
        sum += arr[i];
        while (sum > x && start <= i)
        {
            if (i - start + 1 < minLength)
            {
                minLength = i - start + 1;
            }
            sum -= arr[start++];
        }
    }
    return minLength;
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
    int x;
    cin >> x;
    int ans = minimumLengthSubarray(arr, n, x);
    cout << ans << endl;
    delete[] arr;
    return 0;
}