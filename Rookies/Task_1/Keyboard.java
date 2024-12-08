import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char shift = scn.nextLine().charAt(0);
        String sequence = scn.nextLine();

        char[] keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./".toCharArray();
        String resultStr = "";
        for (char currChar: sequence.toCharArray()){
            for(int i = 0; i < keyboard.length; i++){
                if(currChar == keyboard[i]){
                    resultStr += (shift == 'R')? keyboard[i-1]: keyboard[i+1];
                }
            }
        }
        System.out.println(resultStr);
    }
}
