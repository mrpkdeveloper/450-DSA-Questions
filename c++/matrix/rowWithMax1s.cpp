#include <iostream>
#include <vector>
using namespace std;

int rowWithMax1s(vector<vector<int>> arr, int n, int m)
{
    int maxRow = -1;
    int i = 0, j = m - 1;
    while (j >= 0 && i <= n - 1)
    {
        if (arr[i][j] == 1)
        {
            maxRow = i;
            j--;
        }
        else if (arr[i][j] == 0)
        {
            i++;
        }
    }
    return maxRow;
}

int main()
{
    vector<vector<int>> matrix;
    int m, n;
    cin >> m >> n;
    for (int i = 0; i < m; i++)
    {
        vector<int> temp;
        matrix.push_back(temp);
        for (int j = 0; j < n; j++)
        {
            int element;
            cin >> element;
            matrix[i].push_back(element);
        }
    }
    int ans = rowWithMax1s(matrix, m, n);
    cout << ans << endl;
    return 0;
}