#include <iostream>
using namespace std;

long long maxProduct(int *arr, int n)
{
    long long minVal = arr[0];
    long long maxVal = arr[0];
    long long maxProduct = arr[0];
    for (int i = 1; i < n; i++)
    {
        if (arr[i] < 0)
            swap(maxVal, minVal);
        maxVal = max((long long)arr[i], maxVal * arr[i]);
        minVal = min((long long)arr[i], minVal * arr[i]);
        maxProduct = max(maxProduct, maxVal);
    }
    return maxProduct;
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
    long long int ans = maxProduct(arr, n);
    cout << ans << endl;
    delete[] arr;
    return 0;
}