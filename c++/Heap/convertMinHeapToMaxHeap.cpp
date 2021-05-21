#include <bits/stdc++.h>
using namespace std;

void printArray(vector<int> &arr)
{
    for (auto i : arr)
        cout << i << " ";
    cout << endl;
}

void downHeapify(vector<int> &arr, int parentIndex)
{
    int maxIndex = parentIndex;
    int leftChildIndex = 2 * parentIndex + 1;
    int rightChildIndex = 2 * parentIndex + 2;
    if (leftChildIndex < arr.size() && arr[leftChildIndex] > arr[maxIndex])
        maxIndex = leftChildIndex;
    if (rightChildIndex < arr.size() && arr[rightChildIndex] > arr[maxIndex])
        maxIndex = rightChildIndex;
    if (maxIndex == parentIndex)
        return;
    swap(arr[maxIndex], arr[parentIndex]);
    downHeapify(arr, maxIndex);
}

void convertMinHeapToMaxHeap(vector<int> &arr)
{
    for (int i = (arr.size() / 2) - 1; i >= 0; i--)
        downHeapify(arr, i);
}

int main()
{
    vector<int> arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
    cout << "Min Heap Array : ";
    printArray(arr);
    convertMinHeapToMaxHeap(arr);
    cout << "Max Heap Array : ";
    printArray(arr);
    return 0;
}