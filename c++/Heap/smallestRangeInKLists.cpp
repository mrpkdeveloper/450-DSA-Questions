#include <bits/stdc++.h>
using namespace std;

class Pair
{
public:
    int data;
    int index;
    int arrIndex;
};

bool operator>(const Pair &p1, const Pair &p2)
{
    return p1.data > p2.data;
}

vector<int> smallestRange(vector<vector<int>> &nums)
{
    int min = INT_MAX, max = INT_MIN, range = INT_MAX;
    priority_queue<Pair, vector<Pair>, greater<Pair>> pq;
    for (int i = 0; i < nums.size(); i++)
    {
        Pair p;
        p.data = nums[i][0];
        p.arrIndex = i;
        p.index = 0;
        pq.push(p);
        if (p.data > max)
            max = p.data;
    }
    int finalMin, finalMax;
    min = pq.top().data;
    range = max - min + 1;
    finalMin = min;
    finalMax = max;
    while (true)
    {
        Pair top = pq.top();
        pq.pop();
        if (top.index + 1 < nums[top.arrIndex].size())
        {
            Pair p;
            p.data = nums[top.arrIndex][top.index + 1];
            p.arrIndex = top.arrIndex;
            p.index = top.index + 1;
            pq.push(p);
            if (p.data > max)
                max = p.data;
        }
        else
            break;
        min = pq.top().data;
        if (max - min + 1 < range)
        {
            range = max - min + 1;
            finalMax = max;
            finalMin = min;
        }
    }
    return {finalMin, finalMax};
}

int main()
{
    int k;
    cin >> k;
    vector<vector<int>> lists;
    for (int i = 0; i < k; i++)
    {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int j = 0; j < n; j++)
            cin >> arr[j];
        lists.push_back(arr);
    }
    vector<int> arr = smallestRange(lists);
    for (auto i : arr)
        cout << i << " ";
    cout << endl;
    return 0;
}