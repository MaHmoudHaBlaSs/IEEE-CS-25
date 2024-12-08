import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] bars = new int[n];
        for (int i = 0; i < n; i++)
            bars[i] = scn.nextInt();
        printAliceAndBob(bars);
    }

    public static void printAliceAndBob(int[] bars){
        int a = 1, b = 1;
        // left is Alice, Right is Bob
        int left = 0, right = bars.length-1;
        if(bars.length == 1) {
            System.out.println("1 0"); // If there's only 1 bar. (special case)
            return;
        }
        while (left < right){
            bars[left]--;
            bars[right]--;

            // Alice has more priority than Bob, so it's here earlier in code sequence
            if (bars[left] == 0 && left+1 != right) {
                left++;
                a++;
            }
            if (bars[right] == 0 && right-1 != left) {
                right--;
                b++;
            }
            if (left + 1 == right)
                break;
        }
        System.out.println(a +" "+ b);
    }
}
