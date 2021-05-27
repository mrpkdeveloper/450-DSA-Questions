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

vector<int> minSlidingWindow(vector<int> &nums, int k)
{
    int n = nums.size();
    deque<int> dq;
    vector<int> output;
    for (int i = 0; i < n; i++)
    {
        if (dq.empty() || nums[dq.back()] <= nums[i])
            dq.push_back(i);
        else
        {
            while (!dq.empty() && nums[dq.back()] > nums[i])
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

int sumOfMinAndMaxSubarray(vector<int> &arr, int k)
{
    vector<int> maxSubarray = maxSlidingWindow(arr, k);
    vector<int> minSubarray = minSlidingWindow(arr, k);
    int sum = 0;
    for (int i = 0; i < maxSubarray.size(); i++)
    {
        sum += maxSubarray[i] + minSubarray[i];
    }
    return sum;
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
    int ans = sumOfMinAndMaxSubarray(arr, k);
    cout << ans << endl;
    return 0;
}