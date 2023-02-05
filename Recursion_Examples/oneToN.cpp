// Printing 1 to n 

#include<iostream>
using namespace std;

void print(int n){
    if (n == 0 or n == 1){
        cout << n << endl;
        return;
    }
    else{
        
        print(n - 1);
        cout << n << endl;
        return;
    }
}
int main()
{
    int n;
    cout << "Enter the value of n: " << endl;
    cin >> n;
    print(n);
    return 0;
}
