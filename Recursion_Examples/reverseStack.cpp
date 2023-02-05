/*
Question: Reverse a stack without using extra space.
Link: https://www.codingninjas.com/codestudio/problems/reverse-stack-using-recursion_631875?topList=love-babbar-dsa-sheet-problems

Here we are using recursion twice, once to remove the top element and second 
time to add the element at the bottom of the stack

Although we have used the extra stack but that is just to print the values of 
the stack.

Similar strategies can be used in the following questions of recursion and stack

    1) Delete the middle element of the stack
    2) Reverse a queue

*/



#include <iostream>
#include <stack>
using namespace std;

void print(stack<int> st){
     for (std::stack<int> dump = st; !dump.empty(); dump.pop())
        std::cout << dump.top() << ' ';
}
void solve(stack<int> &st, int x){
    //base
    if(st.empty()){
        st.push(x);
        return;
    }
    //recursion
    int num = st.top();
    st.pop();
    solve(st,x);
    st.push(num);
}
stack<int> insertAtBottom(stack<int> &st, int num){
    solve(st,num);
    return st;
}
void reverseStack(stack<int> &st){
     if(st.empty()){
        return;
    }
    int num = st.top();
    st.pop();
    reverseStack(st);
    insertAtBottom(st,num);
}

int main()
{
    stack<int> st;
    for (int i = 0; i < 11; i++){
        st.push(i);
    }
    cout << "Original Stack: " << endl;
    print(st);
    cout << endl;
    reverseStack(st);
    cout << "Reversed Stack: " << endl;
    print(st);
    return 0;
}
