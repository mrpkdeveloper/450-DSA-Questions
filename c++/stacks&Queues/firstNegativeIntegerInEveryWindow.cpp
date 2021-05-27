#include <bits/stdc++.h>
using namespace std;

vector<int> printFirstNegativeInteger(int arr[], int n, int k)
{
    queue<int> q;
    for (int i = 0; i < k - 1; i++)
    {
        if (arr[i] < 0)
            q.push(arr[i]);
    }
    vector<int> output;
    for (int i = k - 1; i < n; i++)
    {
        if (arr[i] < 0)
            q.push(arr[i]);
        output.push_back((q.empty() ? 0 : q.front()));
        if (arr[i - k + 1] < 0)
            q.pop();
    }
    return output;
}

int main()
{
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int k;
    cin >> k;
    vector<int> output = printFirstNegativeInteger(arr, n, k);
    for (auto i : output)
    {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}