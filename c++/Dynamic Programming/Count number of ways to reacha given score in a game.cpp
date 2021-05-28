long long int count(long long int n)
{
	long long int table[n+1],i;
	memset(table, 0, sizeof(table));
	table[0]=1;                 // If 0 sum is required number of ways is 1.
	
	// Your code here
	// one by one consider all the moves 
	// because we want to find all different permutation
    for (i = 3; i <= n; i++)
    table[i] += table[i - 3];
     
    for (i = 5; i <= n; i++)
    table[i] += table[i - 5];
     
    for (i = 10; i <= n; i++)
    table[i] += table[i - 10];
 
	return table[n];
}