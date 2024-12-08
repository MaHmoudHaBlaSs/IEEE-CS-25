import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int freeTime = scn.nextInt();
        int[] books = new int[n];

        for (int i = 0; i < n; i++)
            books[i] = scn.nextInt();
        System.out.println(getMaxSequence(books, freeTime));
    }
  
    public static int getMaxSequence(int[] books, int totalTime){
        int left = -1, maxSeq = 0, currSum = 0;

        // Sliding Window
        for (int right = 0; right < books.length; right++ ){
            currSum += books[right];

            while (currSum > totalTime){
                left++;
                currSum -= books[left];
            }

            maxSeq = Math.max(maxSeq, right-left);
        }
        return maxSeq;
    }
}
