/*  Given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.  */

// Function to find number of bits needed to be flipped to convert A to B
int countBitsFlip(int a, int b)
{
    int count = 0;
    int last_a, last_b;

    while ((a) || (b))
    {

        last_a = (a & 1);
        last_b = (b & 1);

        if ((last_a ^ last_b))
        { 
            count++;
        }

        a = a >> 1;
        b = b >> 1;
    }

    return count;
}
