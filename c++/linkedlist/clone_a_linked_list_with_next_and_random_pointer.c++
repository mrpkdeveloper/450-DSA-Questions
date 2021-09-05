// Clone a Linked List with next and random pointer
// https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

Node *copyList(Node *head)
{
    Node *root = head;
    unordered_map<Node *, Node *> mp;

    while (root)
    {
        Node *ret = new Node(root->data);
        mp[root] = ret;
        root = root->next;
    }
    root = head;

    while (root)
    {
        mp[root]->next = mp[root->next];
        mp[root]->arb = mp[root->arb];
        root = root->next;
    }

    return mp[head];
}