// Connect n ropes with minimum cost
// Link : https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

long long minCost(long long arr[], long long n) {
        priority_queue<long long,vector<long long>,greater<long long>>minh;
        for(long long i=0;i<n;i++){
            minh.push(arr[i]);
        }
        long long cost=0;
        while(minh.size()>=2){
            long long first=minh.top();
            minh.pop();
            long long second=minh.top();
            minh.pop();
            cost=cost+first+second;
            minh.push(first+second);
        }
        return cost;
    }