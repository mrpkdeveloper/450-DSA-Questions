/*
 Given a string S, The task is to remove all the consecutive duplicate 
 characters of the string and return the resultant string. 

    Input: S= “aaaaabbbbbb”
    Output: ab

    Input: S = “geeksforgeeks”
    Output: geksforgeks

    Input: S = “aabccba”
    Output: abcba

Question Link: https://www.codingninjas.com/codestudio/problems/remove-consecutive-duplicates_893195
*/


#include<stack>
#include<string>
#include<iostream>
using namespace std;

string remove(string s, int start, int n){
    if(s.size() == 1){
        string output = "";
        output = s[start];
        return output;
    }
    char c = s[start];
    string out = remove(s, start + 1, n-1);
    
    if(c == out[0]){
        s.replace(0, 1, "");
    }
    return out;
}
int main()
{
    string s = "bs";
    int n = s.size();
    cout<<remove(s,0,n);
}