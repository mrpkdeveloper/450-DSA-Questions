#include <iostream>
using namespace std;

int merge(int arr[], int start, int end)
{
    int mergedArray[end - start + 1];
    int mid = (start + end) / 2;
    int i = start, j = mid + 1, k = 0;
    int inversionCount = 0;
    while (i <= mid && j <= end)
    {
        if (arr[i] <= arr[j])
        {
            mergedArray[k++] = arr[i++];
        }
        else
        {
            mergedArray[k++] = arr[j++];
            inversionCount += mid + 1 - i;
        }
    }
    while (i <= mid)
    {
        mergedArray[k++] = arr[i++];
    }
    while (j <= end)
    {
        mergedArray[k++] = arr[j++];
    }
    for (int i = 0; i < end - start + 1; i++)
    {
        arr[start + i] = mergedArray[i];
    }
    return inversionCount;
}

int countInversion(int arr[], int n, int start = 0, int end = -1)
{
    if (end == -1)
    {
        end = n - 1;
    }
    int inversionCount = 0;
    if (start < end)
    {
        int mid = (start + end) / 2;
        inversionCount += countInversion(arr, mid - start + 1, start, mid);
        inversionCount += countInversion(arr, end - mid, mid + 1, end);
        inversionCount += merge(arr, start, end);
    }
    return inversionCount;
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
    int ans = countInversion(arr, n);
    cout << ans << endl;
    return 0;
}
