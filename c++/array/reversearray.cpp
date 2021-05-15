#include <bits/stdc++.h>

using namespace std;

// iterative
void reverse_array(vector<int> &arr)
{
    if (arr.size() > 0)
    {
        int low = 0;
        int hi = arr.size() - 1;
        while (low < hi)
        {
            int temp = arr[low];
            arr[low++] = arr[hi];
            arr[hi--] = temp;
        }

        return;
    }

    return;
}

// driver function

// int main()
// {
//     printf("Hey!\n");
//     vector<int> x{1, 2, 3, 4, 5, 6, 7};
//     printf("Hey!\n");
//     reverse_array(x);
//     for (int y : x)
//         cout << y << endl;

//     return 0;
// }