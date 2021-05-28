#include <bits/stdc++.h>
using namespace std;

bool redundantBrackets(string str)
{
    stack<char> s;
    for (auto ch : str)
    {
        if (ch == ')')
        {
            if (s.top() == '(')
                return true;
            bool flag = true;
            while (s.top() != '(')
            {
                if (s.top() == '+' || s.top() == '*' || s.top() == '-' || s.top() == '/')
                    flag = false;
                s.pop();
            }
            if (flag == true)
                return true;
            s.pop();
        }
        else
        {
            s.push(ch);
        }
    }
    return false;
}

int main()
{
    string s;
    cin >> s;
    cout << (redundantBrackets(s) ? "YES" : "NO") << endl;
    return 0;
}