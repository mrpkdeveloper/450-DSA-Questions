//And operator is used 
//If the last digit is 1 after the &(and) operation then it is odd otherwise even
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin >> n;
    if (n & 1)
    {
        cout << "Odd";
    }
    else
    {
        cout << "Even";
    }
    return 0;
}
//This is the code for even or odd number using bit manipulation . As it works on bits it is faster than the general method  
