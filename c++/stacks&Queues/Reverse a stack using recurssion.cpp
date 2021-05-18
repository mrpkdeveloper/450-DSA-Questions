// Reverse a stack using recurssion

// Link : https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/

// This solution is not a optimal one,any one can contribute the optimal solution

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
stack<int> st;
//pushin function to insert elements at correct position
void pushin(int t){
    if(st.size()==0){
        st.push(t);
        return;
    }
    else{
        int val=st.top();
        st.pop();
        pushin(t);
        st.push(val);
        return;
    }
}
//reverse function
void reverse(){
    if(st.size()==1)return;
    int temp=st.top();
    st.pop();
    reverse();
    pushin(temp);
    return;
}

// Driver Code
int main()
{
      
    // push elements into 
    // the stack
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
      
    cout<<"Original Stack"<<endl;
      
    // print the elements 
    // of original stack
    vector<int>v;
    while(!st.empty())
    {
        int p=st.top();
        st.pop();
        v.push_back(p);
    }
      
    //display of reversed stack
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
      
    // function to reverse 
    // the stack
    reverse();
    cout<<"\nReversed Stack"
        <<endl;
      
    // storing values of reversed 
    v.clear();
    while(!st.empty())
    {
        int p=st.top();
        st.pop();
        v.push_back(p);
    }
      
    //display of reversed stack
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
    return 0;
}