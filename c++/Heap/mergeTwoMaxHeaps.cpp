#include <bits/stdc++.h>
using namespace std;

void printArray(int *arr, int n)
{
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}

void downHeapify(int *arr, int n, int parentIndex)
{
    int maxIndex = parentIndex;
    int leftChildIndex = 2 * parentIndex + 1;
    int rightChildIndex = 2 * parentIndex + 2;
    if (leftChildIndex < n && arr[leftChildIndex] > arr[maxIndex])
        maxIndex = leftChildIndex;
    if (rightChildIndex < n && arr[rightChildIndex] > arr[maxIndex])
        maxIndex = rightChildIndex;
    if (maxIndex == parentIndex)
        return;
    swap(arr[maxIndex], arr[parentIndex]);
    downHeapify(arr, n, maxIndex);
}

void mergeHeaps(int merged[], int a[], int b[], int n, int m)
{
    int k = 0;
    for (int i = 0; i < n; i++)
    {
        merged[k++] = a[i];
    }
    for (int i = 0; i < m; i++)
    {
        merged[k++] = b[i];
    }
    for (int i = ((n + m) / 2) - 1; i >= 0; i--)
        downHeapify(merged, n + m, i);
}

int main()
{
    int arr1[] = {10, 5, 6, 2};
    int arr2[] = {12, 7, 9};
    int n = 4, m = 3;
    cout << "Max Heap 1 : ";
    printArray(arr1, n);
    cout << "Max Heap 2 : ";
    printArray(arr2, m);
    int merged[n + m];
    mergeHeaps(merged, arr1, arr2, n, m);
    printArray(merged, n + m);
    return 0;
}