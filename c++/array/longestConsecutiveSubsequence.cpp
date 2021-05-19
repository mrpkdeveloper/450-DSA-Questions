#include <iostream>
#include <unordered_map>
using namespace std;

int findLongestConseqSubseq(int arr[], int n)
{
    //Your code here
    unordered_map<int, bool> arrMap;
    for (int i = 0; i < n; i++)
    {
        arrMap[arr[i]] = true;
    }
    int maxLength = 0;
    for (int i = 0; i < n; i++)
    {
        if (arrMap[arr[i]] == true)
        {
            int length = 1;
            arrMap[arr[i]] = false;
            int temp = arr[i] + 1;
            while (arrMap.count(temp) == 1)
            {
                length++;
                arrMap[temp] = false;
                temp++;
            }
            temp = arr[i] - 1;
            while (arrMap.count(temp) == 1)
            {
                length++;
                arrMap[temp] = false;
                temp--;
            }
            if (length > maxLength)
            {
                maxLength = length;
            }
        }
    }
    return maxLength;
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
    int ans = findLongestConseqSubseq(arr, n);
    cout << ans << endl;
    delete[] arr;
    return 0;
}