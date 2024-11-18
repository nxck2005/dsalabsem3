// Program to demonstrate a circular linked list and all its operations.

// Node class, same as linked list
class Node {
    int info;
    Node link;
    Node(int info) {
        this.info = info;
        this.link = null;
    }
}

class CircularLinkedList {
    private Node start; // Points to the start of the list
    private Node ptr; // Points to the end of the list
    
    public CircularLinkedList() {
        start = null;
        ptr = null;
    }

    // Insert an element at the start of the list 
    // All codes are almost the same as a normal LL, but
    // hiave the added complexity of being circular
    public void CFInsert(int info) {
        Node newnode = new Node(info);
        if(start == null) {
            // If start points to nothing, list is empty
            // add the newnode as the first node, which makes it the first and 
            // the last element. Hence, start and ptr should both point to it
            start = newnode;
            ptr = newnode;
            ptr.link = start;
        } else {
            // If there are nodes in the list, newnode becomes the first node.
            // The former first node (being pointed to by the start ptr) will become
            // the second node, and will be pointed to by newnode.
            // start will then point to newnode, and then ptr will be updated to 
            // point to the new start node.
            newnode.link = start;
            start = newnode;
            ptr.link = start;
        }
        System.out.println("Inserted " + info + " at the beginning");
    }

    // Insert at the last of the list
    public void CLInsert(int info) {
        Node newnode = new Node(info);
        if (start == null) {
            // If start is null, list is empty
            // Do the same as other CFInsert
            start = newnode;
            ptr = newnode;
            ptr.link = start;
        } else {
            // To insert at last, the current last node becomes second last node
            // then newnode becomes last, and as the last node always points to 
            // start, newnode does too
            ptr.link = newnode;
            ptr = newnode;
            ptr.link = start;
        }
        System.out.println("Inserted " + info + " at the end");
    }
    
    // Delete from the beginning of the list
    public void CFDelete() {
        if (start == null) {
            System.out.println("Empty list, cannot delete anything"); // duh
            return;
        }
        // If there is only one node, start and ptr will both point to the same node
        // and will be the only reference to that node. Deleting that only reference
        // will call the garbage collector, and the node will be deleted.
        if (start == ptr) {
            start = null;
            ptr = null;
        } else {
            // If there are multiple nodes, to delete from the start, make start
            // point to the second node which is start.link, and make ptr point to
            // the updated start.
            start = start.link;
            ptr.link = start;
        }
        System.out.println("Deleted node from the beginning");
    }

    // Delete node from the last
    public void CLDelete() {
        // I'm tired of commenting this.. but no start, no nodes
        if (start == null) {
            // .. and no deletion
            System.out.println("List is empty. Cannot delete");
            return;
        }
        // If start be same as ptr, only one node!!!
        // lose reference, praise garbage collector
        if (start == ptr) {
            start = null;
            ptr = null;
        } else {
            // Iterate until the node you iterated to points to last node.
            // That is the second last node, and now should become ptr and 
            // point to start
            Node ptr1 = start;
            while (ptr1.link != ptr) {
                ptr1 = ptr1.link;
            }
            ptr1.link = start;
            ptr = ptr1;
        }
        System.out.println("Deleted node from the end");
    }

    // Print the entire list
    public void printList() {
        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        Node ptr1 = start;
        // do while loop taken instead of while because ptr1 will always point to
        // start and ptr1 not being start is also the stopping condition for the 
        // loop.
        do {
            System.out.print(ptr1.info + " ");
            ptr1 = ptr1.link;
        } while (ptr1 != start);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.CFInsert(20);
        list.CLInsert(49);
        list.CLInsert(63);
        list.CFInsert(98);
        list.printList();
        list.CFDelete();
        list.CLDelete();
        list.printList();
        list.CFDelete();
        list.CLDelete();
        list.printList();
        list.CFDelete();
        list.printList();
    }
}
