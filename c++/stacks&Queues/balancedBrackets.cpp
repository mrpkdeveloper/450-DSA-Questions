#include <bits/stdc++.h>
using namespace std;

bool balancedBrackets(string str)
{
    stack<char> s;
    for (auto ch : str)
    {
        if (ch == '(' || ch == '{' || ch == '[')
            s.push(ch);
        else if (ch == ')')
        {
            if (s.size() && s.top() == '(')
                s.pop();
            else
                return false;
        }
        else if (ch == '}')
        {
            if (s.size() && s.top() == '{')
                s.pop();
            else
                return false;
        }
        else if (ch == ']')
        {
            if (s.size() && s.top() == '[')
                s.pop();
            else
                return false;
        }
    }
    if (s.size())
        return false;
    return true;
}

int main()
{
    string s;
    cin >> s;
    cout << (balancedBrackets(s) ? "YES" : "NO") << endl;
    return 0;
}