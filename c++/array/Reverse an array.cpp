/*C++ program to reverse an array time complexity: O(n)*/
#include <iostream>
using namespace std;
void reverseArray(int arr[], int start, int end)
{
    while (start < end)
    {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
//function to print an array
void printArray(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << endl;
        cout << endl;
    }
}
//driver function
int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    //print original array
    printArray(arr, n);
    //function calling
    reverseArray(arr, 0, n - 1);
    cout << "Reversed array is" << endl;
    //print the reversed array
    printArray(arr, n);
    return 0;
}
