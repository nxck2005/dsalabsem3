// Program to conduct linear search to find a item in an array
// static members are array and size
// loc is initialized to -1 and stays there if item is not found
// Its a flag to check if item is found

import java.util.Scanner;

class LinearSearch {
    static int A[], size;
    
    void lsearch(int item) {
        int loc = -1;
        for (int i = 0; i < size; i++) {
            if (item == A[i]) {
                loc = i;
                break;
            }
        }
        // loc will only be changed to item if it is found, otherwise its -1
        if (loc > 0) {
            System.out.println("\nItem found at location A[" + loc + "]");
        } else {
            System.out.println("\nItem not found in array");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter item to be searched");
        int item = sc.nextInt();
        System.out.println("Enter size of the array");
        size = sc.nextInt();
        
        // Allocate memory for A, only reference was allocated before
        A = new int[size];
        System.out.println("Enter elements of A");
        for (int i = 0; i < size; i++) {
            A[i] = sc.nextInt();
        }

        LinearSearch ls = new LinearSearch();
        ls.lsearch(item);
        sc.close();
        return;
    }
}