#include <bits/stdc++.h>
using namespace std;

class PriorityQueue
{
    vector<int> pq;

private:
    void swap(int &a, int &b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    void downHeapify(int parentIndex)
    {
        int minIndex = parentIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        if (leftChildIndex < pq.size() && pq[leftChildIndex] < pq[minIndex])
            minIndex = leftChildIndex;
        if (rightChildIndex < pq.size() && pq[rightChildIndex] < pq[minIndex])
            minIndex = rightChildIndex;
        if (minIndex == parentIndex)
            return;
        swap(pq[parentIndex], pq[minIndex]);
        downHeapify(minIndex);
    }

    void upHeapify(int childIndex)
    {
        if (childIndex == 0)
            return;
        int parentIndex = (childIndex - 1) / 2;
        if (pq[parentIndex] <= pq[childIndex])
            return;
        swap(pq[parentIndex], pq[childIndex]);
        upHeapify(parentIndex);
    }

public:
    PriorityQueue(vector<int> &arr)
    {
        for (auto i : arr)
        {
            pq.push_back(i);
        }
        for (int i = (pq.size() / 2) - 1; i >= 0; i--)
        {
            downHeapify(i);
        }
    }

    bool isEmpty()
    {
        return pq.size() == 0;
    }

    int getSize()
    {
        return pq.size();
    }

    int getMin()
    {
        if (isEmpty())
        {
            return 0;
        }

        return pq[0];
    }

    void insert(int element)
    {
        pq.push_back(element);
        int childIndex = pq.size() - 1;
        this->upHeapify(childIndex);
    }

    int removeMin()
    {
        // Write your code here
        if (isEmpty())
            return 0;
        int ans = pq[0];
        pq[0] = pq[pq.size() - 1];
        pq.pop_back();
        int parentIndex = 0;
        this->downHeapify(parentIndex);
        return ans;
    }
};

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    PriorityQueue pq(arr);
    int choice;
    cin >> choice;
    while (choice != -1)
    {
        switch (choice)
        {
        case 1: // insert
            int element;
            cin >> element;
            pq.insert(element);
            break;
        case 2: // getMin
            cout << pq.getMin() << "\n";
            break;
        case 3: // removeMax
            cout << pq.removeMin() << "\n";
            break;
        case 4: // size
            cout << pq.getSize() << "\n";
            break;
        case 5: // isEmpty
            cout << (pq.isEmpty() ? "true\n" : "false\n");
            break;
        default:
            return 0;
        }

        cin >> choice;
    }
}