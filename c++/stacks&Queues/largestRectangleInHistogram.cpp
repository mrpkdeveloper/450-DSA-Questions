#include <bits/stdc++.h>
using namespace std;

vector<int> nextSmallerElementRight(vector<int> &heights)
{
    int n = heights.size();
    vector<int> output(n);
    stack<int> s;
    s.push(n - 1);
    output[n - 1] = n;
    for (int i = n - 2; i >= 0; i--)
    {
        while (s.size() && heights[s.top()] >= heights[i])
            s.pop();
        output[i] = (s.size() ? s.top() : n);
        s.push(i);
    }
    return output;
}

vector<int> nextSmallerElementLeft(vector<int> &heights)
{
    int n = heights.size();
    vector<int> output(n);
    stack<int> s;
    s.push(0);
    output[0] = -1;
    for (int i = 1; i < n; i++)
    {
        while (s.size() && heights[s.top()] >= heights[i])
            s.pop();
        output[i] = (s.size() ? s.top() : -1);
        s.push(i);
    }
    return output;
}

int largestRectangleArea(vector<int> &heights)
{
    vector<int> rightBoundary = nextSmallerElementRight(heights);
    vector<int> leftBoundary = nextSmallerElementLeft(heights);
    int maxArea = 0;
    for (int i = 0; i < heights.size(); i++)
    {
        int area = heights[i] * (rightBoundary[i] - leftBoundary[i] - 1);
        if (area > maxArea)
            maxArea = area;
    }
    return maxArea;
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
    int ans = largestRectangleArea(arr);
    cout << ans << endl;
    return 0;
}