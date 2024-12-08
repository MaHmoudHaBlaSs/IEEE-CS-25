import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] stds = new int[n];
        for (int i = 0; i < n; i++)
            stds[i] = scn.nextInt();
        System.out.println(maxPossibleTeam(stds));
    }
    public static int maxPossibleTeam(int[] students){
        Arrays.sort(students); // O(nLog(n))
        int left = 0, maxTeam = 0;
        // left >> min , right >> max
        for (int right = 0; right < students.length; right++){ // O(n)
            int diff = students[right] - students[left];
            while (diff > 5){
                left++;
                diff = students[right]-students[left];
            }
            maxTeam = Math.max(maxTeam, right-left+1);
        }

        return maxTeam;
    }
}
