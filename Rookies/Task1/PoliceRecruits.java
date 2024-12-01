import java.util.Scanner;

public class PoliceRecruits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] events = new int[size];
        for(int i = 0; i < size; i++){
            events[i] = scn.nextInt();
        }
        System.out.println(getUntreated(events));
    }
    public static int getUntreated(int[] events){
        int police = 0, untreated = 0;
        for(int event: events){
            if(event == -1 && police == 0)
                untreated++;
            else if(event == -1 && police != 0)
                police--;
            else // Positive event
                police += event;
        }
        return untreated;
    }
}