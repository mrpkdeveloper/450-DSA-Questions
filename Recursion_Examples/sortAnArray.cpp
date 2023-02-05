/*
                            MERGE SORT

Merge sort is a sorting algorithm in which we sort an array/vector by dividing 
them in halves

ex: 
                        1 8 6 4 2 7 3 5
                          /          \
                     1 8 6 4        2 7 3 5
                      /   \          /   \
                   1 8    6 4     2 7     3 5
                   /  \   /  \    /  \    /  \
                  1    8 6    4  2    7  3    5
                  \   /  \   /   \   /   \   /
                   1 8    4 6     2 7     3 5
                    \       /      \       /
                     1 4 6 8        2 3 5 7
                        \               /
                         1 2 3 4 5 6 7 8 


Question Link: https://www.codingninjas.com/codestudio/problems/merge-sort_920442?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_14
*/


#include <iostream>
#include <vector>
using namespace std;
void printArr(vector<int> arr){
    for (int i = 0; i < arr.size(); i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}
void mergeSortedArr(vector<int> &arr, int l, int r, int m){
    
// here we create 2 sub arrays first and second to store values of left and right
    int firstHalfLen = m - l + 1;       // length of left array
    int secondHalfLen = r - m;          // length of right array

    int *firstHalf = new int[firstHalfLen];
    int *secondHalf = new int[secondHalfLen];
   

    // populate the first array with left array values
    int k = l;
    for (int i = 0; i < firstHalfLen; i++){
        firstHalf[i] = arr[k];
        k++;
    }
    // populate the first array with left array values
    k = m + 1;
    for (int i = 0; i < secondHalfLen; i++){
        secondHalf[i] = arr[k];
        k++;
    }
    
    // below is the algorithm for merging two sorted arrays

    k = l;
    int i = 0;
    int j = 0;
    while (i < firstHalfLen && j < secondHalfLen){
        if(firstHalf[i] <= secondHalf[j]){
            arr[k] = firstHalf[i];
            i++;
            k++;
        }
        else{
            arr[k] = secondHalf[j];
            j++;
            k++;
        }
    }

    while(j < secondHalfLen){
        arr[k] = secondHalf[j];
        j++;
        k++;
    }
    while(i < firstHalfLen){
        arr[k] = firstHalf[i];
        i++;
        k++;
    }
    delete []firstHalf;
    delete []secondHalf;
   
}

void mergeSort(vector<int> &arr, int l, int r){

    if(l>=r){
        return;         // return blank if array is of length 1 or less
    }
    else{
        int m = (l + r) / 2;            // find mid of array
        mergeSort(arr, l, m);           // merge sort on left part (recursion)
        mergeSort(arr, m + 1, r);       // merge sort on right part (recursion)
        mergeSortedArr(arr, l, r, m);   // merge sorted arrays (left and right)
        
    }
}

int main()
{
    /* code */
    vector<int> arr;
    arr.push_back(1);
    arr.push_back(8);
    arr.push_back(6);
    arr.push_back(4);
    arr.push_back(2);
    arr.push_back(7);
    arr.push_back(3);
    arr.push_back(5);
    cout << "Original Array: " << endl;
    printArr(arr);
    int l = 0;
    int r = arr.size() - 1;
    mergeSort(arr, l, r);         // Merge Sort function
    cout << "Sorted Array: " << endl;
    printArr(arr);

    return 0;
}
