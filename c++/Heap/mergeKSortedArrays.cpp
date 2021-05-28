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

vector<int> mergeKArrays(vector<vector<int>> &arr, int k)
{
    priority_queue<Pair, vector<Pair>, greater<Pair>> pq;
    vector<int> output;
    for (int i = 0; i < k; i++)
    {
        Pair p;
        p.data = arr[i][0];
        p.arrIndex = i;
        p.index = 0;
        pq.push(p);
    }
    while (!pq.empty())
    {
        Pair top = pq.top();
        pq.pop();
        output.push_back(top.data);
        if (top.index + 1 < arr[top.arrIndex].size())
        {
            Pair p;
            p.data = arr[top.arrIndex][top.index + 1];
            p.arrIndex = top.arrIndex;
            p.index = top.index + 1;
            pq.push(p);
        }
    }
    return output;
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
    vector<int> arr = mergeKArrays(lists, k);
    for (auto i : arr)
        cout << i << " ";
    cout << endl;
    return 0;
}