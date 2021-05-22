#include <bits/stdc++.h>
using namespace std;

int canCompleteCircuit(vector<int> &gas, vector<int> &cost)
{
    int startIndex = 0;
    int sum = 0;
    for (int i = 0; i < gas.size(); i++)
    {
        sum += gas[i];
        sum -= cost[i];
        if (sum < 0)
        {
            startIndex = (i + 1) % gas.size();
            sum = 0;
        }
    }
    int fuel = gas[startIndex] - cost[startIndex];
    if (fuel < 0)
        return -1;
    for (int i = (startIndex + 1) % gas.size(); i != startIndex; i = (i + 1) % gas.size())
    {
        fuel -= cost[i];
        fuel += gas[i];
        if (fuel < 0)
            return -1;
    }
    return startIndex;
}

int main()
{
    int n;
    cin >> n;
    vector<int> gas(n);
    vector<int> cost(n);
    for (int i = 0; i < n; i++)
    {
        cin >> gas[i];
    }
    for (int i = 0; i < n; i++)
    {
        cin >> cost[i];
    }
    cout << canCompleteCircuit(gas, cost) << endl;
    return 0;
}