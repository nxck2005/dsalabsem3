import java.util.Scanner;

class StackImplementation {
    // Three static members
    // 1. The array that is going to be used as a stack,
    // 2. The upper bound of the stack (maxStack), 
    // 3. The current top element of the stack
    static int stack[], maxStack, top;

    void push(int item) {
        System.out.println("Pushing " + item + " to stack");
        if (top == maxStack - 1) {
            // If top is equal to maxStack, the stack is full as the 
            // top element is present at the last slot in the stack array.
            // The stack is zero indexed hence in the boolean expression
            // we evaluate maxStack - 1.
            System.out.println("Stack overflow!");
        } else {
            top++;
            stack[top] = item; // Increment top by 1 and insert item at that place
        }
    }

    void pop() {
        System.out.println("Popping the top element from the stack");
        if (top == -1) {
            // If top hasn't been changed since it's been initialized to -1,
            // or it got reduced from 0 to 1 after popping the last element,
            // there is no element in the stack array, hence:
            System.out.println("Stack underflow!");
        } else {
            top = top - 1; // No reference left for the element above top, so its considered
                           // deleted.
        }
    }

    void show() {
        System.out.println("Stack elements starting from the top: ");
        for (int i = top; i >= 0; i--) { // Print every element from the top by decrementing counter 
                                         // by 1 from the top
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int item1, item2, item3, item4, item5;

        StackImplementation sp = new StackImplementation();

        System.out.println("Item 1?");
        item1 = sc.nextInt();
        System.out.println("Item 2?");
        item2 = sc.nextInt();
        System.out.println("Item 3?");
        item3 = sc.nextInt();
        System.out.println("Item 4?");
        item4 = sc.nextInt();
        System.out.println("Item 5?");
        item5 = sc.nextInt();

        System.out.println("Max stack?");
        StackImplementation.maxStack = sc.nextInt();

        // After inputting all data;
        // Create the stack array of size maxStack and set top to -1 
        // which symbolises the top pointer being present at a position behind 0, 
        // hence before any elements are present therefore empty
        stack = new int[maxStack];
        top = -1;
        
        sp.show();
        sp.pop();
        sp.push(item1);
        sp.show();
        sp.push(item2);
        sp.show();
        sp.push(item3);
        sp.show();
        sp.push(item4);
        sp.show();
        sp.push(item5);
        sp.show();
        sp.push(item1);
        sp.show();
        sp.pop();
        sp.show();
        sp.pop();
        sp.show(); 
        sc.close();
        return;
    }
}
