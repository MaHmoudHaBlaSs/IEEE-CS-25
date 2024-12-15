import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        applyAlgorithm(num);
    }
    // Collatz Conjecture Algorithm
    public static void applyAlgorithm(int num){
        System.out.println(num);
        if (num == 1)
            return;
        if (num%2 == 0) // Even
            applyAlgorithm(num/2);
        else{ // Odd
            applyAlgorithm(num*3 + 1);
        }
    }
}
