#include <bits/stdc++.h>
using namespace std;

int getKthLargest(vector<int> &arr, int k)
{
    //	Write your code here.
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < arr.size(); i++)
    {
        int sum = arr[i];
        if (pq.size() < k)
        {
            pq.push(sum);
        }
        else
        {
            if (sum > pq.top())
            {
                pq.pop();
                pq.push(sum);
            }
        }
        for (int j = i + 1; j < arr.size(); j++)
        {
            sum += arr[j];
            if (pq.size() < k)
            {
                pq.push(sum);
            }
            else
            {
                if (sum > pq.top())
                {
                    pq.pop();
                    pq.push(sum);
                }
            }
        }
    }
    return pq.top();
}

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int k;
    cin >> k;
    int ans = getKthLargest(arr, k);
    cout << ans << endl;
    return 0;
}