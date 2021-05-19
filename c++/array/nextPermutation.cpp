#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void reverse(int arr[], int start, int end)
{
    int i = start, j = end;
    while (i < j)
    {
        swap(arr[i++], arr[j--]);
    }
}

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

void nextPermutation(int arr[], int n)
{
    int index1 = -1, index2;
    for (int i = n - 2; i >= 0; i--)
    {
        if (arr[i] < arr[i + 1])
        {
            index1 = i;
            break;
        }
    }
    if (index1 == -1)
    {
        reverse(arr, 0, n - 1);
        return;
    }
    for (int i = n - 1; i > index1; i--)
    {
        if (arr[i] > arr[index1])
        {
            index2 = i;
            break;
        }
    }
    swap(arr[index1], arr[index2]);
    reverse(arr, index1 + 1, n - 1);
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
    nextPermutation(arr, n);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    delete[] arr;
    return 0;
}