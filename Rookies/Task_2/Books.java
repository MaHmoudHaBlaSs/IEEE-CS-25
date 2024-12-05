import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int freeTime = scn.nextInt();
        int[] books = new int[n];
        for (int i = 0; i < n; i++)
            books[i] = scn.nextInt();

        // Solution
        // Sliding Window Algorithm
        int l = -1, currentTimeSum = 0, largestGroup = 0;
        for (int r = 0; r < n; r++){
            currentTimeSum += books[r];
            while (currentTimeSum > freeTime){
                l++;
                currentTimeSum -= books[l];
            }
            largestGroup = Math.max(largestGroup, r-l);
        }
        System.out.println(largestGroup);
    }
}