// Flatten a Linked List
// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

struct compare
{
    bool operator()(struct Node *t1, struct Node *t2)
    {
        return t1->data > t2->data;
    }
};

struct Node *flatten(struct Node *root)
{
    struct Node *t = root;
    struct Node *head = NULL;

    priority_queue<Node *, vector<Node *>, compare> pq;

    while (t != NULL)
    {
        pq.push(t);
        t = t->next;
    }

    while (!pq.empty())
    {
        struct Node *temp = pq.top();
        pq.pop();

        if (temp->bottom != NULL)
        {
            pq.push(temp->bottom);
        }

        if (head == NULL)
        {
            head = temp;
            t = temp;
            t->next = NULL;
        }
        else
        {
            t->bottom = temp;
            t = temp;
            t->next = NULL;
        }
    }
    return head;
}