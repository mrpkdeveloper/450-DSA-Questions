// Mobile numeric keypad
// https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1

class Solution
{
public:
    long long getCount(int n)
    {
        if (n == 1)
        {
            return 10;
        }

        // list of array
        list<long long int> l[10];
        l[0].assign({0, 8});
        l[1].assign({1, 2, 4});
        l[2].assign({2, 1, 3, 5});
        l[3].assign({3, 6, 2});
        l[4].assign({4, 1, 7, 5});
        l[5].assign({5, 4, 6, 2, 8});
        l[6].assign({6, 3, 5, 9});
        l[7].assign({7, 4, 8});
        l[8].assign({8, 5, 0, 7, 9});
        l[9].assign({9, 6, 8});

        long long int count[10];
        for (int i = 0; i < 10; i++)
        {
            count[i] = 1;
        }

        for (int i = 2; i <= n; i++)
        {
            long long int countTemp[10] = {0};
            for (int j = 0; j < 10; j++)
            {
                for (int x : l[j])
                {
                    countTemp[x] += count[j];
                }
            }
            for (int j = 0; j < 10; j++)
            {
                count[j] = countTemp[j];
            }
        }

        long long int total = 0;
        for (int i = 0; i < 10; i++)
        {
            total += count[i];
        }
        return total;
    }
}