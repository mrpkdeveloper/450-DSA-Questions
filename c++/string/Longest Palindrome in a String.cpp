//Link : https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
/*
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).


Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".*/
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution {
  public:
    string longestPalin (string s)
    {
        int n = s.size();
        
        bool dp[n][n];
        memset(dp, false, sizeof(dp));
        int first,last,max=INT_MIN;
        
        for(int i=n-1; i>=0; i--)
        {
            for(int j=i; j<=n-1; j++)
            {
                if(i==j)
                    dp[i][j] = true;
                else if(s[i] == s[j])
                {
                    if(j-i == 1)
                        dp[i][j]=true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j] && j-i >= max)
                {
                    max=j-i;
                    first=i;
                    last=j;
                }
            }
        }
        return s.substr(first,last-first+1);;
    }
     
};

// { Driver Code Starts.

int main()
{
    int t; cin >> t;
    while (t--)
    {
        string S; cin >> S;
        
        Solution ob;
        cout << ob.longestPalin (S) << endl;
    }
}
 
  // } Driver Code Ends
