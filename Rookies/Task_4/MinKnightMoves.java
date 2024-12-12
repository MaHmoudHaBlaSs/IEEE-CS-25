import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); 
        while (testCases-- > 0) {
            String[] positions = scanner.nextLine().split(" ");
            System.out.println(minKnightMoves(positions[0], positions[1]));
        }
    }

    private static int minKnightMoves(String start, String destination) {
        int startX = start.charAt(0) - 'a';  
        int startY = start.charAt(1) - '1';  
        int destX = destination.charAt(0) - 'a';
        int destY = destination.charAt(1) - '1';

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        boolean[][] visited = new boolean[8][8];
        
        // perform BFS , starting with the initial position and 0 moves
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true; 

        //  BFS until we find the destination
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); 
            int x = current[0], y = current[1], moves = current[2]; 


            if (x == destX && y == destY) {
                return moves;
            }

            // possible knight moves
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i], newY = y + dy[i]; // new position

                
                if (isValid(newX, newY, visited)) { // Valid position
                    queue.add(new int[]{newX, newY, moves + 1}); 
                    visited[newX][newY] = true; // mark the new position as visited
                }
            }
        }

        return -1; // If destination is not reachable
    }

    // to check if a move is valid
    private static boolean isValid(int x, int y, boolean[][] visited) {
        return x >= 0 && x < 8 && y >= 0 && y < 8 && !visited[x][y];
    }
}
