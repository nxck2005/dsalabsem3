package dsalabsem3.assignment2;

// Ignore for actual assessment in lab
// Iterative binary search uses a void function
// Binary search uses divide and conquer
// Assumes sortedness of array

import java.util.Scanner;

class BinarySearchIterative {
    static int A[], size;

    void BSearch(int item) {
        int loc = -1;
        int lb = 0, ub = size - 1, mid = 0;

        while (lb <= ub) {
            mid = (lb + ub) / 2;
            if (item == A[mid]) {
                loc = mid;
                break;
            } else if (item > A[mid]) {
                lb = mid + 1;
            } else if (item < A[mid]) {
                ub = mid - 1;
            }
        }

        if (loc > 0) {
            System.out.println("Element found at location A[" + loc + "]");  
        } else {
            System.out.println("Element not found in array.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter item to search");
        int item = sc.nextInt();

        System.out.println("Enter size of array");
        size = sc.nextInt();

        System.out.println("Enter elements into the array");
        A = new int[size];

        for (int i = 0; i < size; i++) {
            A[i] = sc.nextInt();
        }

        BinarySearchIterative bs = new BinarySearchIterative();
        bs.BSearch(item);
        sc.close();
        return;
    }
}
