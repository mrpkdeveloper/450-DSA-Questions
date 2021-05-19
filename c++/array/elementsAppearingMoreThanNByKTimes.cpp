#include <iostream>
#include <unordered_map>
using namespace std;

void moreThanNdK(int arr[], int n, int k)
{
    unordered_map<int, int> arrMap;
    for (int i = 0; i < n; i++)
    {
        if (arrMap.count(arr[i]) == 1)
        {
            arrMap[arr[i]]++;
        }
        else
        {
            arrMap[arr[i]] = 1;
        }
    }
    int appearanceCount = n / k;
    unordered_map<int, int>::iterator it = arrMap.begin();
    while (it != arrMap.end())
    {
        if (it->second > appearanceCount)
        {
            cout << "Number:" << it->first << " Count:" << it->second << endl;
        }
        it++;
    }
}

int main()
{
    int n;
    cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int k;
    cin >> k;
    moreThanNdK(arr, n, k);
    delete[] arr;
    return 0;
}