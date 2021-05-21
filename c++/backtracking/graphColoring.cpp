#include <bits/stdc++.h>
using namespace std;

bool isSafe(vector<int> graph[], int v, vector<int> &color, int start, int c)
{
    for (auto vertex : graph[start])
    {
        if (color[vertex] == c)
        {
            return false;
        }
    }
    return true;
}

bool graphColoringUtil(vector<int> graph[], int v, vector<int> &color, int start, int m)
{
    if (start == v)
    {
        return true;
    }
    for (int i = 0; i < m; i++)
    {
        if (isSafe(graph, v, color, start, i))
        {
            color[start] = i;
            if (graphColoringUtil(graph, v, color, start + 1, m))
            {
                return true;
            }
            color[start] = -1;
        }
    }
    return false;
}

void printSolution(vector<int> &color)
{
    for (auto i : color)
    {
        cout << i << " ";
    }
    cout << endl;
}

bool graphColoring(vector<int> graph[], int v, int m)
{
    vector<int> color(v, -1);
    if (!graphColoringUtil(graph, v, color, 0, m))
    {
        cout << "Not possible to cover for the given value of m" << endl;
        return false;
    }
    printSolution(color);
    return true;
}

int main()
{
    int v, e;
    cin >> v >> e;
    vector<int> graph[v];
    for (int i = 0; i < e; i++)
    {
        int src, dest;
        cin >> src >> dest;
        graph[src].push_back(dest);
        graph[dest].push_back(src);
    }
    int m;
    cin >> m;
    bool ans = graphColoring(graph, v, m);
    cout << (ans ? "YES" : "NO") << endl;
    return 0;
}