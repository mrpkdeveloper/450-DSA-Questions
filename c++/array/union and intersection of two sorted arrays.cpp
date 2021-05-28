//Problem-Find the union and intersection of two sorted arrays
#include <bits/stdc++.h>
using namespace std;

int printUnion(int a1[], int a2[], int m, int n)
{
    int i = 0;
    int j = 0;
    while (i < m && j < n)

    {
        if (a1[i] < a2[j])
            cout << a1[i++] << " ";

        else if (a1[i] > a2[j])
            cout << a2[j++] << " ";
        else
        {
            cout << a2[j++] << " ";
            i++;
        }
    }
    while (i < m)
        cout << a1[i++] << " ";

    while (j < n)
        cout << a2[j++] << " ";
}
int printIntersection(int a1[], int a2[], int m, int n)
{
    int i = 0;
    int j = 0;
    while (i < m && j < n)

    {
        if (a1[i] < a2[j])
            i++;
        else if (a1[i] > a2[j])
            j++;
        else
        {
            cout << a2[j++] << " ";
            i++;
        }
    }
}

int main()
{
    int a1[] = {1, 2, 4, 5, 6};
    int a2[] = {2, 3, 5, 7};

    int m = sizeof(a1) / sizeof(a1[0]);
    int n = sizeof(a2) / sizeof(a2[0]);

    printUnion(a1, a2, m, n);
    cout << "\n";
    printIntersection(a1, a2, m, n);
}
