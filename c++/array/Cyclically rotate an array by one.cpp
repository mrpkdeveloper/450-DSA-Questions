//Link : https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1

/*
Given an array, rotate the array by one position in clock-wise direction.
 

Example 1:

Input:
N = 5
A[] = {1, 2, 3, 4, 5}
Output:
5 1 2 3 4*/
#include<bits/stdc++.h>
using namespace std;

int main()
 {      
     ios_base:: sync_with_stdio(false);
     cin.tie(NULL);
     cout.tie(NULL);
     
     
	//code by Raunak Pandey
	int t;
	cin>>t;
	while(t--)
	{
	    int i,n;
	    cin>>n;
	    int arr1[n];
	    vector <int> v;
	    for(i=0;i<n;i++)
	    {
	        cin>>arr1[i];
	        v.push_back(arr1[i]); 
	    }
	    rotate(v.begin(),v.begin()+v.size()-1,v.end());
	     for(int x:v)
	     {
	         cout<<x<<" ";
	     }
	    cout<<endl;
	}
	return 0;
}