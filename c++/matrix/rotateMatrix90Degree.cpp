#include <iostream>
using namespace std;

void swap(int &a, int &b)
{
    int temp = a;
    a = b;
    b = temp;
}

void reverse(int arr[], int n)
{
    int start = 0, end = n - 1;
    int i = start, j = end;
    while (i < j)
    {
        swap(arr[i++], arr[j--]);
    }
}

void transpose(int arr[][100], int m, int n)
{
    for (int i = 0; i < m; i++)
    {
        for (int j = i; j < n; j++)
        {
            swap(arr[i][j], arr[j][i]);
        }
    }
}

void rotateAntiClockwise(int arr[][100], int m, int n)
{
    for (int i = 0; i < m; i++)
    {
        reverse(arr[i], n);
    }
    transpose(arr, m, n);
}

void rotateClockwise(int arr[][100], int m, int n)
{
    transpose(arr, m, n);
    for (int i = 0; i < m; i++)
    {
        reverse(arr[i], n);
    }
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
    rotateClockwise(arr, m, n);
    // rotateAntiClockwise(arr, m, n);
    cout << " " << endl;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}