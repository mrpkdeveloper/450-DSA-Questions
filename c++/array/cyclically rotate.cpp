#include<bits/stdc++.h>
using namespace std;
int main() 
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        vector<int>vec(n);
        for(int i=0;i<n;i++)
        {
            cin>>vec.at(i);
        }
        rotate(vec.begin(),vec.begin()+vec.size()-1,vec.end());
        for(int i=0;i<n;i++)
        {
            cout<<vec[i]<<" ";
        }
        cout<<endl;
    }
    return 0;
}