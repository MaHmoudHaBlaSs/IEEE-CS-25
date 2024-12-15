import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getFib(n));
        scn.close();
    }
    public static int getFib(int n){
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else // n > 1
            return getFib(n-1) + getFib(n-2);
    }
}
