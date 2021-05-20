#include <iostream>
using namespace std;

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

void rearrange(int arr[], int n)
{
    int i = 0, j = 0;
    while (i < n && j < n)
    {
        while (arr[i] >= 0)
        {
            i++;
        }
        while (arr[j] < 0)
        {
            j++;
        }
        if (i >= n || j >= n)
        {
            break;
        }
        int pos = arr[j];
        int neg = arr[i];
        for (int k = max(i, j); k > min(i, j) + 1; k--)
        {
            arr[k] = arr[k - 1];
        }
        arr[min(i, j)] = neg;
        arr[min(i, j) + 1] = pos;
        if (min(i, j) == i)
        {
            i += 2;
            j = i;
        }
        else
        {
            j += 2;
            i = j;
        }
    }
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
    rearrange(arr, n);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    delete[] arr;
    return 0;
}