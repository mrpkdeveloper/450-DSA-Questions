// Factorials of large numbers
// Link : https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
void multiply(int x, vector<int>&res)
{
    int carry = 0;  // Initialize carry
 
    for (int i=0; i<res.size(); i++)
    {
        int prod = res[i] * x + carry;
 
        res[i] = prod % 10;  
 
        carry  = prod/10;    
    }
 
    while (carry)
    {
        res.push_back(carry%10);
        carry = carry/10;
    }
    
}
 
    vector<int> factorial(int N){
        
        vector<int>res;
 
    res.push_back(1);
    int res_size=1;

    for (int x=2; x<=N; x++)
         multiply(x, res);
        
         reverse(res.begin(),res.end());
         return res;
    }