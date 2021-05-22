#include <bits/stdc++.h>
using namespace std;

string findSum(string n1, string n2)
{
    string n3 = "";
    int carry = 0;
    int i = n1.length() - 1, j = n2.length() - 1;
    while (i >= 0 || j >= 0 || carry)
    {
        int sum = 0;
        if (i >= 0)
            sum += (n1[i--] - '0');
        if (j >= 0)
            sum += (n2[j--] - '0');
        sum += carry;
        carry = sum / 10;
        n3 += sum % 10 + '0';
    }
    reverse(n3.begin(), n3.end());
    while (n3[0] == '0')
    {
        if (n3.length() == 1)
            return "0";
        n3 = n3.substr(1);
    }
    return n3;
}

string solve(int arr[], int n)
{
    // code here
    sort(arr, arr + n);
    string n1 = "", n2 = "";
    for (int i = 0; i < n; i++)
    {
        if (i % 2 == 0)
        {
            n1 += to_string(arr[i]);
        }
        else
        {
            n2 += to_string(arr[i]);
        }
    }
    string ans = findSum(n1, n2);
    return ans;
}

int main()
{
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    string ans = solve(arr, n);
    cout << ans << endl;
    return 0;
}