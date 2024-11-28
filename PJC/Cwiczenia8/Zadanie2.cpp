#include <iostream>
#include <cstdlib>

struct Node
{
    int data;
    Node *next;
};

bool present(const Node *head, int data)
{
    while (head != nullptr)
    {
        if(head -> data == data)
            return true;
        head = head -> next;
    }
    return false;
}

bool add(Node *&head, int data)
{
    if(!present(head, data))
    {
        Node *newNode = (Node *) (malloc(sizeof(Node *)));
        newNode -> data = data;
        newNode -> next = head;
        head = newNode;
        return true;
    }
    return false;
}

size_t size(const Node *head)
{
    size_t size = 0;
    while (head != nullptr)
    {
        size++;
        head = head -> next;
    }
    return size;
}

void clear(Node *& head)
{
    Node *current = head;
    Node *n = nullptr;

    while (current != nullptr)
    {
        n = current -> next;
        free(current);
        current = n;
    }
    head = nullptr;
}

void printList (Node *head)
{
    while (head != nullptr)
    {
        std::cout << head -> data << " ";
        head = head -> next;
    }
}

int main()
{
    using std::cout, std::cin, std::endl;
    int tab[] = {1,4,1,3,5};
    Node *head = nullptr;

    for(size_t i = 0, e = std::size(tab); i != e; ++i)
    {
        bool b = add(head, tab[i]);
        cout << tab[i] << (b ? " " : " NOT ") << "ADDED" << endl;
    }
    cout << "Size of list: " << size(head) << endl;
    printList(head);
    clear(head);
    return 0;
}
