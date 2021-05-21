#include <bits/stdc++.h>
using namespace std;

void printPermutations(string str, string ans)
{
    if (str.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    for (int i = 0; i < str.length(); i++)
    {
        char letter = str[i];
        string remainingString = str.substr(0, i) + str.substr(i + 1);
        printPermutations(remainingString, ans + letter);
    }
}

int main()
{
    string str;
    cin >> str;
    printPermutations(str, "");
    return 0;
}