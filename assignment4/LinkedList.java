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
        // If start points to nothing, there are zero nodes in the list so you can't delete anything
        // Print a underflow message to the user
        if (start == null) {
            System.out.println("Stack underflow, no change was made!");
            return;
        }

        // 2 cases can happen now
        // Either one node is present or N nodes are present.
        // If one node is present, simply remove the reference of the first node in start
        // and the node is effectively lost and considered deleted.
        // IF N nodes are present, the second node (the node which the first node points to, i.e. start.link)
        // would become the first node.
        // Start would then have the reference to second node instead of first, and start.link would then point to 
        // nothing and would be lost and considered deleted.
        // To have a reference to the first node before deletion to help with this, initialize a Node ptr to start.
        // Also set the first node's link to null to avoid a dangling pointer
        
        Node ptr = start;
        if (start.link == null) { // If only one node is present, remove reference of it from start and remove ptr.link
            start = null;
            ptr.link = null;
        } 
        
        start = start.link // The reference of the first node now points to the second node
        ptr.link = null; // Avoid dangling pointer by setting the former first node to null
    }

    // Delete the last node in the list
    void LDelete() {
        // Again, if start points to null, no node is present hence can't delete anything
        if (start == null) {
            System.out.println("Stack underflow, no change was made");
            return;
        }
        
        // Again, initialize a pointer to start for future reference to first node
        // And in this case, we'll need the node before it too, for changing of links after the first pointer is 
        // deleted.
        // For it, we can initialize two pointers pointing to start and start.link 
        // We can make ptr2 follow its links, and make ptr1 follow ptr2 until ptr2's link reaches null
        // At last, ptr2 will contain last node and ptr1 will be the second last.
        // Then make the second last node point to nothing (ptr1.link = null). Then the reference to last node is lost
        // hence the node is effectively deleted as there is no way to reference it.

        Node ptr1 = start;
        Node ptr2 = start.link;

        while (ptr2.link != null) {
            ptr1 = ptr2;
            ptr2 = ptr2.link;
        }

        ptr1.link = null;
    }

    // Helper function to print the entire list
    // By traversing the entire list using links from start node.
    void printList() {
        Node ptr = start;
        while (ptr != null) {
            System.out.println(ptr.info + " ");
            ptr = ptr.link;
        }
    }

    // Main function to demonstrate linked lists
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        return;
    }
}
    

