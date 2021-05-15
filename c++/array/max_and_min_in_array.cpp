// Find the maximum and minimum element in an array
// Contributed by Vaibhav Sharma
// 3 approaches
#include<bits/stdc++.h>
using namespace std;
pair<int,int> max_and_min1(int arr[],int n)
{
    int max = INT_MIN;
    int min = INT_MAX;
    for(int i = 0 ; i < n ; i++)
    {
        if(arr[i] > max)
            max = arr[i];
        if(arr[i] < min)
            min = arr[i];
    }
    pair<int,int> a;
    a.first = max;
    a.second = min;
    return a;
}
pair<int,int> max_and_min2(int start,int end,int arr[])
{
    pair<int,int> a;
    if(start == end)
    {
        a.first = a.second = arr[start];
        return a;
    }
    else if(start == end - 1)
    {
        if(arr[end] > arr[start])
        {
            a.first = arr[end];
            a.second = arr[start];
        }
        else
        {
            a.first = arr[start];
            a.second = arr[end];
        }
        return a;
    }
    else 
    {
        int mid = (start + end) / 2;
        pair<int,int> left = max_and_min2(start,mid,arr);
        pair<int,int> right = max_and_min2(mid+1,end,arr);
        if(left.first > right.first)
            a.first = left.first;
        else
            a.first = right.first;
        if(left.second < right.second)
            a.second = left.second;
        else
            a.second = right.second;
        return a;
    }
}
pair<int,int> max_and_min3(int start,int end,int arr[])
{
    pair<int,int> a;
    if(start == end)
    {
        a.first = a.second = arr[start];
        return a;
    }
    else if(start == end - 1)
    {
        if(arr[end] > arr[start])
        {
            a.first = arr[end];
            a.second = arr[start];
        }
        else
        {
            a.first = arr[start];
            a.second = arr[end];
        }
        return a;
    }
    else
    {
        int global_max = INT_MIN;
        int global_min = INT_MAX;
        int max = INT_MIN;
        int min = INT_MAX;
        while(start<=end)
        {
            if(arr[start] > arr[start+1])
            {
                max = arr[start];
                min = arr[start+1];
            }
            else
            {
                max = arr[start+1];
                min = arr[start];
            }
            if(global_max < max)
                global_max = max;
            if(global_min > min)
                global_min = min;
            start+=2;
        }
        a.first = global_max;
        a.second = global_min;
        return a;
    }
}
int main()
{
    pair<int,int> pair;
    int n;
    cin >> n;
    int a[n];
    for(int i = 0 ; i < n ; i++)
        cin >> a[i];
    pair = max_and_min3(0,n-1,a);
    cout << "Max : " << pair.first << endl << "Min : " << pair.second << endl;
    return 0;
}