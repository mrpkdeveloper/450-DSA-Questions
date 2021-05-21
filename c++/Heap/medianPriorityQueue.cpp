#include <bits/stdc++.h>
using namespace std;

// here median is the central element in odd number of elements and the smaller one of the
// center elements in case of even elements

class MedianFinder
{
private:
    priority_queue<int> left;
    priority_queue<int, vector<int>, greater<int>> right;

public:
    /** initialize your data structure here. */
    MedianFinder()
    {
    }

    int removeMedian()
    {
        if (this->size() == 0)
            return -1;
        int ans = 0;
        if (left.size() >= right.size())
        {
            ans = left.top();
            left.pop();
        }
        else if (right.size() > left.size())
        {
            ans = right.top();
            right.pop();
        }
        return ans;
    }

    void addNum(int num)
    {
        if (right.size() != 0 && right.top() <= num)
        {
            right.push(num);
        }
        else
        {
            left.push(num);
        }
        if ((int)(left.size() - right.size()) > 1)
        {
            right.push(left.top());
            left.pop();
        }
        else if ((int)(right.size() - left.size()) > 1)
        {
            left.push(right.top());
            right.pop();
        }
    }

    double findMedian()
    {
        if (this->size() == 0)
            return -1;
        if (left.size() >= right.size())
            return left.top();
        else
            return right.top();
    }

    int size()
    {
        return left.size() + right.size();
    }
};

int main()
{
    MedianFinder *obj = new MedianFinder();
    cout << obj->findMedian() << endl;
    obj->addNum(10);
    obj->addNum(20);
    cout << obj->findMedian() << endl;
    obj->addNum(30);
    cout << obj->findMedian() << endl;
    obj->addNum(40);
    cout << obj->findMedian() << endl;
    obj->removeMedian();
    cout << obj->findMedian() << endl;
    delete obj;
    return 0;
}