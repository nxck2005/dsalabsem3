// Program to implement linked list, its nodes and perform all operations possible.

// Definition of a node. 
// Has one data field and one field containing the pointer to the next field.
// A bunch of nodes linked together can comprise a linked list
class Node {
    int info;
    Node link;
    Node(int item) {
        // Initialize a node with a given item, and make the node point to nothing.
        // It will be linked to and from a linked list seperately
        this.info = item;
        this.link = null;
    }
}

// Definition of linked list and all its operations
public class LinkedList {
    // Intialize a pointer that points to the start of the linked list for every instance.
    // Useful in doing operations
    // can be called head, start etc.
    // When linked list is initialized, there are no nodes in the list, so the start pointer
    // will point to nothing. Hence, intitialize each instance of start pointer to null
    Node start = null;

    // Insert a node at the start of the linked list
    void FInsert(int item) {
        // Make the node to insert with the given data field
        Node newnode = new Node(item);

        // Two cases can arise
        // If start points to nothing, the linked list is empty
        // Make newnode the first node by making start point to newnode
        if (start == null) {
            start = newnode;
        } else {
            // Else, there are n number of nodes present in the linked list. (say)
            // then to make newnode the first node, start must point to it, and the node
            // previously pointed to by start should end up being pointed to by newnode.link.
            newnode.link = start;
            start = newnode;
        }
    }
 
    // Insert a node at the end of the linked list
    void LInsert(int item) {
        // Make the node to insert with the given data field
        Node newnode = new Node(item);
        
        // Three cases can arise
        // 1. No nodes present
        // 2. One node present
        // 3. N nodes present
        //
        // When no nodes present, make newnode first node
        if (start == null) {
            start = newnode;
        } else if (start.link == null) {
            // If start.link = null, only one node is present.
            // newnode can be inserted at last which is after the singular node present, so make the singular node's
            // link point to the newnode.
            start.link = newnode;
        } else {
            // Else, there are N number of nodes present.
            // We can do what we did when only one node was present, but with the last of those N nodes.
            // To find the nth node, a pointer is taken, initialized to start, and made to traverse the links until
            // the pointer lands on a node whose link is null, which can only be the end node.
            // Then, make that node point to the newnode.
            Node ptr = start;
            while (ptr.link != null) {
                ptr = ptr.link;
            }
            ptr.link = newnode;
        }
    }

    // Delete the node at the start of the list
    void FDelete() {
        // If start points to nothing, there ar


