#include <bits/stdc++.h>
using namespace std;

class PriorityQueue
{
    // Declare the data members here
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
        int maxIndex = parentIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        if (leftChildIndex < pq.size() && pq[leftChildIndex] > pq[maxIndex])
            maxIndex = leftChildIndex;
        if (rightChildIndex < pq.size() && pq[rightChildIndex] > pq[maxIndex])
            maxIndex = rightChildIndex;
        if (maxIndex == parentIndex)
            return;
        swap(pq[maxIndex], pq[parentIndex]);
        downHeapify(maxIndex);
    }

    void upHeapify(int childIndex)
    {
        if (childIndex == 0)
            return;
        int parentIndex = (childIndex - 1) / 2;
        if (pq[parentIndex] > pq[childIndex])
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

    /**************** Implement all the public functions here ***************/

    void insert(int element)
    {
        // Implement the insert() function here
        pq.push_back(element);
        int childIndex = pq.size() - 1;
        this->upHeapify(childIndex);
    }

    int getMax()
    {
        // Implement the getMax() function here
        if (isEmpty())
            return 0;
        return pq[0];
    }

    int removeMax()
    {
        // Implement the removeMax() function here
        if (isEmpty())
            return 0;
        int ans = pq[0];
        pq[0] = pq[pq.size() - 1];
        pq.pop_back();
        int parentIndex = 0;
        this->downHeapify(parentIndex);
        return ans;
    }

    int getSize()
    {
        // Implement the getSize() function here
        return pq.size();
    }

    bool isEmpty()
    {
        // Implement the isEmpty() function here
        return pq.size() == 0;
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
        case 2: // getMax
            cout << pq.getMax() << "\n";
            break;
        case 3: // removeMax
            cout << pq.removeMax() << "\n";
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