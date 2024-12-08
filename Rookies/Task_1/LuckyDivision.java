import java.util.Scanner;

public class LuckyDivision {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        System.out.println(isAlmostLucky(num)?"YES": "NO");

    }

    public static boolean isAlmostLucky(int num){
        int[] luckyNums = {4, 7, 44, 47, 74, 77, 444, 447, 474,477,744, 747, 774, 777};
        for (int lucky: luckyNums){
            if(num%lucky == 0)
                return true;
        }
        return false;
    }


}
