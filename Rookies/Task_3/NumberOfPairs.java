import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++){
            int n = scn.nextInt(), l = scn.nextInt(), r = scn.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = scn.nextInt();
            System.out.println(getGroups(arr, l, r));
        }
    }
    // We need groups where sum >= l and <= r
    public static int getGroups(int[] arr, int l , int r){
        Arrays.sort(arr);
        int left , right;
        int groups = 0;

        for (int i = 0; i < arr.length; i++){
            left = i +1;
            right = arr.length-1;

            while (left <= right){
                int leftBound = arr[i]+arr[left];
                int rightBound = arr[i]+arr[right];

                // If leftBound and rightBound satisfies given l and r, then it's guaranteed that all values between
                // left and right pointers ,which has those bounds, are also have valid bounds.
                if (leftBound >= l && rightBound <= r){
                    groups += right-left+1;
                    break;
                }
                if (leftBound < l){
                    while (left+1 < arr.length && arr[left+1] == arr[left]) // avoiding duplicates
                        left++;
                    left++;
                }
                if (rightBound > r){
                    while (right-1 > 0 && arr[right-1] == arr[right])
                        right--;
                    right--;
                }
            }
        }
        return groups;
    }
}
