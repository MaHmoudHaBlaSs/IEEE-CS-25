import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {
    public static void main(String[] args) {
        // Scanning Inputs.
        Scanner scn = new Scanner(System.in);
        int size1 =  scn.nextInt();
        int[] stores = new int[size1];
        for (int i= 0; i < size1; i++){
            stores[i] = scn.nextInt();
        }
        int size2 = scn.nextInt();
        int[] budgets = new int[size2];
        for (int i= 0; i < size2; i++){
            budgets[i] = scn.nextInt();
        }
        // Implementing Solution
        Arrays.sort(stores); // Dual-Pivot QuickSort O(nLog(n))
        for(int budget : budgets){
            System.out.println(getAvailableStores(stores, budget));
        }
    }
    public static int getAvailableStores(int[] stores, int budget){
        int l = 0, r = stores.length-1; // Indexes

        while (l<=r){
            int midInd = (l+r)/2;
            // You may find more than one store selling for the same price so by using this condition it's guaranteed
            // That left pointer will point to the last valid store
            // [2, 5, 5, 6] >> l = 2
            if (stores[midInd] <= budget)
                l = midInd+1;
            else
                r = midInd-1;
        }
        return l;
    }
}
