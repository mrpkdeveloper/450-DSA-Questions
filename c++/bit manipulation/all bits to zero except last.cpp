//Set all bits to zero except last 
include <bits/stdc++.h>
using namespace std;
int allBitsToZeroExceptLast(int n)
{
    return (n & -n);
}
int main()
{
    int n;
    cin >> n;
    cout << allBitsToZeroExceptLast(n);
}

//Input: 15-->1111
//Output:1-->0001(all bits except the last bit are converted to zero)
