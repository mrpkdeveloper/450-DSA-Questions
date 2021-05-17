/* Kth smallest element
Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.
*/
//Link : https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

// arr : given array
// l : starting index of the array i.e 0
// r : ending index of the array i.e size-1
// k : find kth smallest element and return using this function
#include<bits/stdc++.h>
using namespace std;
void swap(int *a,int *b)
{
    int t=*a;
        *a=*b;
        *b=t;
}
int partition(int ar[],int low,int high)
{
    int pivot,i;
    pivot=ar[high];
    i=low-1;
    for(int j=low;j<high;j++)
    {
        if(ar[j]<pivot)
          {
            i++;
            swap(&ar[i],&ar[j]);
          }
    }
    swap(&ar[i+1],&ar[high]);
    return(i+1);
}
int quicksort(int ar[],int low,int high)
{
  if(low<high)
  {
        int pi;
        pi=partition(ar,low,high);
        quicksort(ar,low,pi-1);
        quicksort(ar,pi+1,high);
  }
}
int main()
{
  int limit,k;
  cin>>limit;
  int ar[limit];
  for(int i=0;i<limit;i++)
    cin>>ar[i];
  cin>>k;
  quicksort(ar,0,limit-1);
  cout<<ar[k-1];
  return 0;
}