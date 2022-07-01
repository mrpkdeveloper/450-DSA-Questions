#include <iostream>
using namespace std;
int main()
{
    int n, m;
    cout << "Enter the size of matrix:\n";
    cin >> n >> m;
    int arr[n][m];
    cout << "enter array elements\n";
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> arr[i][j];
        }
    }
    //Transpose logic:
    cout << "Transpose of give Matrix is :\n";
    for (int i = 0; i < n; i++)
    {
        for (int j = i; j < m; j++)
        {
            //swaping technique..
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }

    //priting matrix:
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}