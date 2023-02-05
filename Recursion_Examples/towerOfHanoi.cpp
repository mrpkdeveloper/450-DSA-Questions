/*
Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk
###Sample Input:

3
###Sample Output:

Disk 1 moved from A to C
Disk 2 moved from A to B
Disk 1 moved from C to B
Disk 3 moved from A to C
Disk 1 moved from B to A
Disk 2 moved from B to C
Disk 1 moved from A to C


Question Link: https://www.codingninjas.com/codestudio/problems/tower-of-hanoi_981323?topList=top-recursion-and-backtracking-interview-questions
*/


#include<vector>
#include<iostream>
using namespace std;

void solve(int n, int s, int d, int h){

    
    if(n == 1){
        cout << "Top Disk of " << s << " moved to " << d << endl;
        return;
    }
    solve(n-1, s, h, d);
    solve(1, s,d,h);
    solve(n-1, h, d, s);
    return;

}
int main(){
    
 
    int s = 1;   //source refered as 1
    int h = 2;   // helper refered as 2
    int d = 3;   // destination refered as 3
    int n = 1;
    solve(n, s, d, h);
    return 0;
}