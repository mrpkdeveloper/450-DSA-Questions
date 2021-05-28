#include <bits/stdc++.h>
using namespace std;

vector<int> nextSmallerElement(vector<int> &arr, int n)
{
    // Write your code here
    vector<int> output(n);
    stack<int> s;
    int minIndex = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] < arr[minIndex])
            minIndex = i;
    }
    s.push(arr[minIndex]);
    output[minIndex] = -1;
    for (int i = (minIndex == 0 ? n - 1 : minIndex - 1); i != minIndex; i = (i == 0 ? n - 1 : i - 1))
    {
        while (s.size() > 0 && s.top() >= arr[i])
            s.pop();
        output[i] = (s.size() ? s.top() : -1);
        s.push(arr[i]);
    }
    return output;
}

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n, 0);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    vector<int> output = nextSmallerElement(arr, n);
    for (auto i : output)
    {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}