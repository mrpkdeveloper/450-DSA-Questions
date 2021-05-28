#include <bits/stdc++.h>
using namespace std;

// O(NlogN) approach
// class Pair
// {
// public:
//     char ch;
//     int freq;
// };

// bool operator<(const Pair &p1, const Pair &p2)
// {
//     return p1.freq < p2.freq;
// }

// string reorganizeString(string s)
// {
//     priority_queue<Pair> pq;
//     unordered_map<char, int> map;
//     for (auto ch : s)
//     {
//         map[ch]++;
//     }
//     for (auto it : map)
//     {
//         Pair p;
//         p.ch = it.first;
//         p.freq = it.second;
//         pq.push(p);
//     }
//     Pair tempHolder;
//     tempHolder.ch = '\0';
//     tempHolder.freq = 0;
//     string ans = "";
//     while (true)
//     {
//         if (pq.empty())
//         {
//             if (tempHolder.ch != '\0')
//                 ans = "";
//             break;
//         }
//         Pair top = pq.top();
//         pq.pop();
//         ans += top.ch;
//         top.freq--;
//         if (tempHolder.ch != '\0')
//             pq.push(tempHolder);
//         if (top.freq)
//             tempHolder = top;
//         else
//         {
//             tempHolder.ch = '\0';
//             tempHolder.freq = 0;
//         }
//     }
//     return ans;
// }

// O(N) approach
string reorganizeString(string s)
{
    unordered_map<char, int> map;
    for (auto ch : s)
    {
        map[ch]++;
    }
    char maxChar = '\0';
    int maxFreq = 0;
    for (auto it : map)
    {
        if (it.second > maxFreq)
        {
            maxFreq = it.second;
            maxChar = it.first;
        }
    }
    if (maxFreq > (s.length() + 1) / 2)
        return "";
    string ans = s;
    int index = 0;
    while (maxFreq)
    {
        s[index] = maxChar;
        maxFreq--;
        index += 2;
    }
    map.erase(maxChar);
    for (auto it : map)
    {
        while (it.second)
        {
            index = (index >= s.length() ? 1 : index);
            s[index] = it.first;
            index += 2;
            it.second--;
        }
    }
    return s;
}

int main()
{
    string s;
    cin >> s;
    string ans = reorganizeString(s);
    cout << ans << endl;
    return 0;
}