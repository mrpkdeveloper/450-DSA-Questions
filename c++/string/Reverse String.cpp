// Reverse String
// Link : https://leetcode.com/problems/reverse-string/

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

void reverseString(vector<char>& s) {
        int n=s.size()-1;
        int i=0;
        while(i<n){
            swap(s[i++],s[n--]);
            
        }
    }