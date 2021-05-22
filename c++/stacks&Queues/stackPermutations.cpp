#include <bits/stdc++.h>
using namespace std;

bool validateStackSequences(vector<int> &pushed, vector<int> &popped)
{
    if (pushed.size() != popped.size())
        return false;
    int j = 0;
    stack<int> s;
    for (int i = 0; i < pushed.size(); i++)
    {
        s.push(pushed[i]);
        while (!s.empty() && s.top() == popped[j])
        {
            s.pop();
            j++;
        }
    }
    while (!s.empty())
    {
        if (s.top() != popped[j])
            return false;
        else
        {
            s.pop();
            j++;
        }
    }
    return true;
}

int main()
{
    int n;
    cin >> n;
    vector<int> pushed(n);
    vector<int> popped(n);
    for (int i = 0; i < n; i++)
    {
        cin >> pushed[i];
    }
    for (int i = 0; i < n; i++)
    {
        cin >> popped[i];
    }
    cout << (validateStackSequences(pushed, popped) ? "YES" : "NO") << endl;
    return 0;
}