#include<bits/stdc++.h>

using namespace std;

int power(int x, int n){

    //base case
    if(n == 0){
        return 1;
    }
    //recusive case
    int smallOutput = power(x,n-1);
    // calculation
    return x * smallOutput;
}

int main(){

    cout<<power(5,3);
    return 0;
}