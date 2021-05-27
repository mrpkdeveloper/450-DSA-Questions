// method-> 1

    int setBits(int N) {
        // Write Your Code here
        int c=0;
        while(N)
        {
            c++;
            N=N&(N-1);    // go on every set bit
        }
        return c;
    }

// method-> 2

    int setBits(int N) {
        // Write Your Code here
        int c=0;
        while(N)
        {
            c+=(N&1)?1:0;   // check for every bit
            N=N>>1;
        }
        return c;
    }

// method-> 3

    int setBits(int N) {
        // Write Your Code here
        return __builtin_popcount(N);   // using builin function
    }