#include <bits/stdc++.h>
using namespace std;

vector<int> nextGreaterElements(vector<int> &arr)
{
    int n = arr.size();
    vector<int> output(n);
    stack<int> s;
    int maxIndex = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > arr[maxIndex])
            maxIndex = i;
    }
    s.push(arr[maxIndex]);
    output[maxIndex] = -1;
    for (int i = (maxIndex == 0 ? n - 1 : maxIndex - 1); i != maxIndex; i = (i == 0 ? n - 1 : i - 1))
    {
        while (s.size() > 0 && s.top() <= arr[i])
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
    vector<int> output = nextGreaterElements(arr);
    for (auto i : output)
    {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}