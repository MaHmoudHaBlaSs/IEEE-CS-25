import java.util.Scanner;

public class ArrivalOfGeneral {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] soldiers = new int[size];
        for(int i = 0; i < size; i++){
            soldiers[i] = scn.nextInt();
        }
        System.out.println(getMinTime(soldiers));
    }
    public static int getMinTime(int[] soldiers){
        int min = 0, max = 0; // Indexes
        for(int i = 1; i < soldiers.length; i++){
            if (soldiers[i] <= soldiers[min])
                min = i;
            if (soldiers[i] > soldiers[max])
                max = i;
        }
        if(min > max)
            return max+soldiers.length-1-min;
        else
            return max+soldiers.length-2-min;
    }
}
