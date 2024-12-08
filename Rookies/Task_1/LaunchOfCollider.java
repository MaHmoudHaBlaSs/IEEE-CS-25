import java.util.Scanner;

public class LaunchOfCollider {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        scn.nextLine();
        String directions = scn.nextLine();
        int[] coordinates = new int[size];
        for(int i = 0; i < size; i++){
            coordinates[i] = scn.nextInt();
        }

        int time = 0, minTime = 0;
        int pattern = 0;
        for (int i= 0; i < size-1; i++) {
            if (directions.charAt(i) == 'R' && directions.charAt(i + 1) == 'L'){
                time = (coordinates[i + 1] - coordinates[i]) / 2;
                if (pattern == 0) // First RL
                    minTime = (coordinates[i + 1] - coordinates[i]) / 2;
                else if (time < minTime)
                    minTime = time;
                i++;
                pattern++;
            }
        }
        if(pattern == 0) System.out.println(-1);
        else System.out.println(minTime);

    }
}
