import java.util.Scanner;

public class BurningMidnightOil {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        //Solution
        System.out.println(getMinV(n, k));
    }
    public static int getMinV(int n, int k){
        int l = 1, r = n;
        int minV = n;

        while (l <= r) {
            int mid = (l + r) / 2;
            int s = getS(mid, k);

            if (s >= n) {
                r = mid - 1;
                minV = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return minV;
    }
    public static int getS(int v, int k){
        int s = 0;

        for (int i = 0; ;i++){
            int term = v/(int)Math.pow(k, i);
            if ( term != 0){
                s += term;
            }else{ // term == 0
                break;
            }
        }
        return s;
    }
}