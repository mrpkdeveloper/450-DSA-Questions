#include <bits/stdc++.h>
using namespace std;

void display(vector<vector<int>> &chess)
{
    for (auto i : chess)
    {
        for (auto j : i)
        {
            cout << j << " ";
        }
        cout << endl;
    }
}

void knightTour(vector<vector<int>> &chess, int r, int c, int move)
{
    if (r < 0 || c < 0 || r >= chess.size() || c >= chess[0].size() || chess[r][c] > 0)
    {
        return;
    }
    else if (move == chess.size() * chess.size())
    {
        chess[r][c] = move;
        display(chess);
        cout << endl;
        chess[r][c] = 0;
        return;
    }
    chess[r][c] = move;
    knightTour(chess, r - 2, c + 1, move + 1);
    knightTour(chess, r - 1, c + 2, move + 1);
    knightTour(chess, r + 1, c + 2, move + 1);
    knightTour(chess, r + 2, c + 1, move + 1);
    knightTour(chess, r + 2, c - 1, move + 1);
    knightTour(chess, r + 1, c - 2, move + 1);
    knightTour(chess, r - 1, c - 2, move + 1);
    knightTour(chess, r - 2, c - 1, move + 1);
    chess[r][c] = 0;
}

int main()
{
    int n, r, c;
    cin >> n >> r >> c;
    vector<vector<int>> chess(n, vector<int>(n, 0));
    knightTour(chess, r, c, 1);
    return 0;
}