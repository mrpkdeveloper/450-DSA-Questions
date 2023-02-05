/*
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. 
Now in every subsequent row, we look at the previous row and replace each 
occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd 
row is 0110.Given two integer n and k, return the kth (1-indexed) symbol 
in the nth row of a table of n rows.


Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0

Question Link: https://leetcode.com/problems/k-th-symbol-in-grammar/
*/


#include<iostream>
#include<cstring>
#include<cmath>
using namespace std;
bool getGrammer(int n, int k){
    int diff = pow(2, n - 2);
    cout << "n: " << n << " "
         << "k: " << k <<"diff: "<<diff<< endl;

    if (n == 1){
        return false;
    }
    if(k <= diff){
        return getGrammer(n-1, k);
    }
    return (!(getGrammer(n-1, k-diff)));
    }
int main()
{
    int n = 2;
    int k = 1;
    bool ans = getGrammer(n, k);
        if(ans){
            cout<< 1;
        }
        else{
            cout << 0;
        }
        return 0;
}
