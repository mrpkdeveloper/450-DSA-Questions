#include <bits/stdc++.h>
using namespace std;

void printMatrixPath(vector<vector<int>> &mat, int m, int n, int sr, int sc, int dr, int dc, string ans)
{
    if (sr > dr || sc > dc)
    {
        return;
    }
    if (sr == dr && sc == dc)
    {
        ans += to_string(mat[sr][sc]) + " ";
        cout << ans << endl;
    }
    ans += to_string(mat[sr][sc]) + " ";
    printMatrixPath(mat, m, n, sr, sc + 1, dr, dc, ans);
    printMatrixPath(mat, m, n, sr + 1, sc, dr, dc, ans);
}

int main()
{
    int m, n;
    cin >> m >> n;
    vector<vector<int>> mat(m, vector<int>(n));
    int num = 1;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            mat[i][j] = num++;
        }
    }
    printMatrixPath(mat, m, n, 0, 0, m - 1, n - 1, "");
    return 0;
}