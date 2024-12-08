import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();
        System.out.println(getPairs(nums, k));
    }

    // O(nLog(n))
    public static int getPairs(int[] nums, int diff){
        Arrays.sort(nums); // O(nLog(n))
        int pairs = 0;

        // O(nLog(n))
        for (int i = 0; i < nums.length; i++){ // O(n)
            int left = i+1, right = nums.length-1;

            while (left <= right){ // O(Log(n))
                int midInd = (left+right)/2;
                int currDiff = nums[midInd] - nums[i];

                if (currDiff > diff)
                    right = midInd-1;
                else if (currDiff < diff)
                    left = midInd+1;
                else{ // midDiff == diff
                    pairs++;
                    break;
                }
            }
        }
        return pairs;
    }
}
