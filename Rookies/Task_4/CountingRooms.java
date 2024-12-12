import java.util.*;

public class RoomCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        boolean[][] visited = new boolean[n][m];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        int roomCount = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    roomCount++; 
                    exploreRoom(grid, visited, i, j, n, m, dx, dy); 
                }
            }
        }

        System.out.println(roomCount);
    }

    private static void exploreRoom(char[][] grid, boolean[][] visited, int startX, int startY, int n, int m, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Check all 4 possible directions (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // If the new position is valid and part of the room '.' and not visited
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == '.' && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY}); 
                    visited[newX][newY] = true; // mark as visited
                }
            }
        }
    }
}
