// sort a stack using recurssion
// Link : https://practice.geeksforgeeks.org/problems/sort-a-stack/1

/*The structure of the class is
class SortedStack{
public:
  stack<int> s;
  void sort();
};
*/

void insert(stack<int>&s,int temp){
    if(s.size()==0 or temp>=s.top()){s.push(temp);return;}
    int val=s.top();
    s.pop();
    insert(s,temp);
    s.push(val);
    return;
}
void SortedStack :: sort()
{
   if(s.size()==1)return;
   int temp=s.top();
   s.pop();
   sort();
   insert(s,temp);
   return;
}