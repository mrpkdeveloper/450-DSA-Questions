//This program needs a sorted array.
#include <iostream>
using namespace std;
int binarySearch(int array[], int, int); //declearation..
int main()
{
    int i, size, array[size];
    cout << "Enter size of an array\n";
    cin >> size;
    cout << "Enter elements of array\n";
    for (i = 0; i < size; i++)
    {
        cin >> array[i];
    }
    int key;
    cout << "enter a key\n";
    cin >> key;
    cout<< key <<" Present at index : ";
    cout<<binarySearch(array,key,size)<<endl;
}
int binarySearch(int array[], int key, int size)
{
    int starting = 0, ending = size;
    while (starting <= ending)
    {
        int mid = (starting + ending) / 2;
        if (array[mid] == key)
            return mid;
        else if (array[mid] > key)
        {
            ending = mid - 1;
        }
        else
        {
            starting = mid + 1;
        }
    }return -1;  //Here -1 repersents error.!
}