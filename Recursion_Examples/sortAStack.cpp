/*
    Question: Sort a stack without using a extra space
    Question link: https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275
*/


#include <iostream>
#include <stack>
using namespace std;

void printStack(stack<int> st){
    stack<int> dummy = st;
    while(!dummy.empty()){
        cout << dummy.top() << " ";
        dummy.pop();
    }
    cout << endl;
}

void fillStack(stack<int> &st, int num){
    if(st.empty() || (!st.empty() && (st.top() < num))){
        st.push(num);
        return;
    }
    int x = st.top();
    st.pop();
    fillStack(st, num);
    st.push(x);
}
void sortStack(stack<int> &st){
    if(st.empty()){
        return;
    }
    int num = st.top();
    st.pop();
    sortStack(st);
    fillStack(st, num);
}

int main()
{
    stack<int> st;
    st.push(3);
    st.push(6);
    st.push(1);
    st.push(8);
    st.push(5);
    st.push(7);
    st.push(2);
    st.push(4);
    cout << "Original Stack: " << endl;
    printStack(st);
    sortStack(st);
    cout << "Sorted Stack: " << endl;
    printStack(st);

    return 0;
}
