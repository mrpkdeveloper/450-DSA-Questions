    int findPosition(int N) {
        // code here
        int x = N & (N - 1);
        if(N && !x)    // check number is power of two or not
        {
            int c=0;
            while(N)
            {
                c++;
                N=N>>1;
            }
            return c;
        }
        else
        return -1;
    }