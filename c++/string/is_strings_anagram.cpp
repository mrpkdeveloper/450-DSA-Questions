#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
bool Anagram(string str_1, string str_2)
{

    int len_str_1 = str_1.length();
    int len_str_2 = str_2.length();

    if (len_str_1 != len_str_2)
    {
        return false;
    }
    sort(str_1.begin(), str_1.end());
    sort(str_2.begin(), str_2.end());

    for (int i = 0; i < len_str_1; i++)
    {
        if (str_1[i] != str_2[i])
        {
            return false;
        }
    }
    return true;
}

int main()
{
    char str_1[50];
    char str_2[50];
    cout << "Enter first string : ";
    cin >> str_1;
    cout << "Enter second string : ";
    cin >> str_2;
    if (Anagram(str_1, str_2))
    {
        cout << "Entered strings are anagrams of each other";
    }
    else
    {
        cout << "Entered strings are not anagrams of each other";
    }
    return 0;
}