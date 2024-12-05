import java.util.Scanner;

public class PointsOnLine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int[] points = new int[n];
        for(int i = 0; i < n; i++)
            points[i] = scn.nextInt();

        // Solution
        long groups = 0;
        int r = 0;
        // traversing each group head point
        for (int l = 0; l < n; l++){
            while (r < n && points[r] - points[l] <= d){
                r++;
            }
            // when exiting the while we will have r pointing to the first point that has d greater than input
            // 1 10 20 30 50 | l = 0, r = 3
            int validPoints = r-1-l;  // valid points to be combined with 1 (left)
            // if valid points are greater than or equal to 2 then we can have group of 3 points else we can't have a group
            // we use Combination equation to tell how many ways we can put those valid points in groups of 2.
            // C = n(n-1)/2 >> where n is the number of points we want to arrange (valid points)
            groups += (validPoints >= 2)?(long)validPoints*(validPoints-1)/2:0;
            // casted to long because int*int/2 won't always fit in int it may exceed the space (overflow)
        }
        System.out.println(groups);
    }
}