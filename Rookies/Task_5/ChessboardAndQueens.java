import java.util.Scanner;

public class Main {

    static int solutionsCount = 0;
    static boolean[] usedColumns = new boolean[8];
    static boolean[] usedPrimaryDiagonals = new boolean[15];
    static boolean[] usedSecondaryDiagonals = new boolean[15];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessboard = new char[8][8];

        for (int row = 0; row < 8; row++) {
            chessboard[row] = scanner.next().toCharArray();
        }

        placeQueens(chessboard, 0);
        System.out.println(solutionsCount);
    }

    public static void placeQueens(char[][] chessboard, int currentRow) {
        if (currentRow == 8) {
            solutionsCount++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (chessboard[currentRow][col] == '.' 
                && !usedColumns[col] 
                && !usedPrimaryDiagonals[currentRow - col + 7] 
                && !usedSecondaryDiagonals[currentRow + col]) {
                
                usedColumns[col] = true;
                usedPrimaryDiagonals[currentRow - col + 7] = true;
                usedSecondaryDiagonals[currentRow + col] = true;

                placeQueens(chessboard, currentRow + 1);

                usedColumns[col] = false;
                usedPrimaryDiagonals[currentRow - col + 7] = false;
                usedSecondaryDiagonals[currentRow + col] = false;
            }
        }
    }
}
