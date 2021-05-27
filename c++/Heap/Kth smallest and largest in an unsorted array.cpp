// Kth smallest and largest in an unsorted array
// Link : https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
// if you want you can see the above link for the solutions.
// Below is the approach which is not there in geeks for geeks
// Leetcode link : https://leetcode.com/problems/kth-largest-element-in-an-array/
// Refer the above problem ,approach the kth smallest element will be same as this.

//kth largest element
int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int,vector<int>,greater<int>> minh;//minheap
        for(int i=0;i<nums.size();i++){
            minh.push(nums[i]);
            if(minh.size()>k){
                minh.pop();
            }
        }
        return minh.top();
    }

//kth smallest element
int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> maxh;//maxheap
        for(int i=0;i<nums.size();i++){
            maxh.push(nums[i]);
            if(maxh.size()>k){
                maxh.pop();
            }
        }
        return maxh.top();
    }