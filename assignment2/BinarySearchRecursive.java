import java.util.Scanner;

class BinarySearchRecursive {
    static int A[], n, mid, item;
// Returns loc at the end.
    int BSearch(int lb, int ub) {
        if (ub >= lb && A.length != 1) {
            mid = (lb + ub) / 2;
            if (item == A[mid]) {
                return (mid);
            } else if (item > A[mid]) {
                lb = mid + 1;
                return BSearch(lb, ub);
            } else if (item < A[mid]) {
                ub = mid - 1;
                return BSearch(lb, ub);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item to search");
        item = sc.nextInt();
        System.out.println("Enter size of array");
        n = sc.nextInt();
        System.out.println("Enter elements into array");
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        BinarySearchRecursive bs = new BinarySearchRecursive();
        int loc = bs.BSearch(0, n - 1);
        if (loc > 0) {
            System.out.println("\nItem found at location: " + loc);
        } else {
            System.out.println("\nItem not found in array.");
        }
    }
}