#include <bits/stdc++.h>
using namespace std;

vector<int> maxSlidingWindow(vector<int> &nums, int k)
{
    int n = nums.size();
    deque<int> dq;
    vector<int> output;
    for (int i = 0; i < n; i++)
    {
        if (dq.empty() || nums[dq.back()] >= nums[i])
            dq.push_back(i);
        else
        {
            while (!dq.empty() && nums[dq.back()] < nums[i])
                dq.pop_back();
            dq.push_back(i);
        }
        if (i >= k - 1)
        {
            while (!dq.empty() && dq.front() <= i - k)
                dq.pop_front();
            output.push_back(nums[dq.front()]);
        }
    }
    return output;
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
    vector<int> output = maxSlidingWindow(arr, k);
    for (auto i : output)
    {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}