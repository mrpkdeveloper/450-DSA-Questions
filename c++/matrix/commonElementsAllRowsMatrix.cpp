#include <iostream>
#include <unordered_map>
using namespace std;

void commonElements(int arr[][100], int m, int n)
{
    unordered_map<int, int> matrixMap;
    for (int i = 0; i < n; i++)
    {
        matrixMap[arr[0][i]] = 1;
    }
    for (int i = 1; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (matrixMap[arr[i][j]] == i)
            {
                matrixMap[arr[i][j]] = i + 1;
                if (i == m - 1)
                {
                    cout << arr[i][j] << " ";
                }
            }
        }
    }
    cout << endl;
}

int main()
{
    int arr[100][100];
    int m, n;
    cin >> m >> n;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
    }
    commonElements(arr, m, n);
    return 0;
}