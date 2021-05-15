// Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
// Contributed by Vaibhav Sharma
// 2 approaches
#include<bits/stdc++.h>
using namespace std;
void sort_0_1_2(int a[], int n) // Algo used for sorting taking O(n) time and O(1) space
{
    int zero = 0;       // storing the number of zero's
    int one = 0;        // storing the number of one's
    int two = 0;        // storing the number of two's
    for(int i= 0 ; i < n; i++)  //  iterating on the loop for counting the number of 0,1,2
    {
        if(a[i] == 0)
            zero++;
        else if(a[i] == 1)
            one++;
        else
            two++;
    }
    for(int i = 0 ; i < n ; i++)    //  modifying the array
    {
        if(zero == 0)
        {
            if(one == 0)
            {
                two--;
                a[i] = 2;
                continue;
            }
            else
            {
                one--;
                a[i] = 1;
                continue;
            }
        }
        else
        {
            zero--;
            a[i] = 0;
            continue;
        }
    }
}
void sort_0_1_2_2(int arr[],int n)  // alternate algo for sorting taking O(n) time and O(1) space
{   // using 3 way partitioning
    int l,mid,h;    // used as index pointers
    l = mid = 0;    // starting from the start
    h = n-1;    // starting from the end
    while(mid<=h)
    {
        switch(arr[mid])    // checking the value at middle
        {
            case 0: swap(arr[l++],arr[mid++]);  // in case of 0, swap the mid and low and increment both
                    break;
            case 1: mid++;  // in case of 1, increment mid
                    break;
            case 2: swap(arr[mid],arr[h--]);    // in case of 2, swap the high and mid, decrement h
                    break;
        }
    }
}   // this algo can also be implemented using pointers
int main()
{
    int n;
    cin >> n;
    int a[n];
    for(int i = 0 ; i < n ; i++)    // input the array
        cin >> a[i];
    sort_0_1_2_2(a,n);
    for(int i = 0 ; i <n ; i++)     // output the array
        cout << a[i] << " ";
    return 0;
}