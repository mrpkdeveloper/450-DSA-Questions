#include <bits/stdc++.h>
using namespace std;

void heapSort(int arr[], int n)
{
    // Write your code
    for (int i = 0; i < n; i++)
    {
        int child = i;
        while (child > 0)
        {
            int parent = (child - 1) / 2;
            if (arr[parent] < arr[child])
            {
                int temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;
            }
            else
                break;
            child = parent;
        }
    }
    int size = n;
    for (int i = 0; i < n; i++)
    {
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        while (leftChildIndex < size)
        {
            int maxIndex = parentIndex;
            if (arr[leftChildIndex] > arr[maxIndex])
                maxIndex = leftChildIndex;
            if (rightChildIndex < size && arr[rightChildIndex] > arr[maxIndex])
                maxIndex = rightChildIndex;
            if (maxIndex == parentIndex)
                break;
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
            parentIndex = maxIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
    }
}

int main()
{
    int size;
    cin >> size;

    int *input = new int[size];

    for (int i = 0; i < size; i++)
    {
        cin >> input[i];
    }

    heapSort(input, size);

    for (int i = 0; i < size; i++)
    {
        cout << input[i] << " ";
    }

    delete[] input;
}