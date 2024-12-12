import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static char[] moves = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] labyrinth = new char[n][m];
        int[][] monsterTime = new int[n][m];
        for (int[] row : monsterTime) Arrays.fill(row, Integer.MAX_VALUE);

        int startX = 0, startY = 0;
        Queue<int[]> monsterQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                labyrinth[i][j] = line.charAt(j);
                if (labyrinth[i][j] == 'A') {
                    startX = i;
                    startY = j;
                } else if (labyrinth[i][j] == 'M') {
                    monsterQueue.offer(new int[]{i, j});
                    monsterTime[i][j] = 0; // monster starting time is 0
                }
            }
        }


        while (!monsterQueue.isEmpty()) {
            int[] curr = monsterQueue.poll();
            int x = curr[0], y = curr[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (isValid(nx, ny, n, m) && labyrinth[nx][ny] == '.' && monsterTime[nx][ny] > monsterTime[x][y] + 1) {
                    monsterTime[nx][ny] = monsterTime[x][y] + 1;
                    monsterQueue.offer(new int[]{nx, ny});
                }
            }
        }


        Queue<int[]> playerQueue = new LinkedList<>();
        int[][] playerTime = new int[n][m];
        for (int[] row : playerTime) Arrays.fill(row, -1); // -1 for unvisited
        playerQueue.offer(new int[]{startX, startY});
        playerTime[startX][startY] = 0;

        int[][] parent = new int[n][m];
        for (int[] row : parent) Arrays.fill(row, -1);

        boolean found = false;
        int endX = -1, endY = -1;

        while (!playerQueue.isEmpty()) {
            int[] curr = playerQueue.poll();
            int x = curr[0], y = curr[1];

            if (isBoundary(x, y, n, m)) {
                found = true;
                endX = x;
                endY = y;
                break;
            }

            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (isValid(nx, ny, n, m) && labyrinth[nx][ny] == '.' && playerTime[nx][ny] == -1) {
                    if (playerTime[x][y] + 1 < monsterTime[nx][ny]) {
                        playerTime[nx][ny] = playerTime[x][y] + 1;
                        playerQueue.offer(new int[]{nx, ny});
                        parent[nx][ny] = d;
                    }
                }
            }
        }

        if (found) {
            out.println("YES");
            StringBuilder path = new StringBuilder();
            int x = endX, y = endY;
            while (!(x == startX && y == startY)) {
                int d = parent[x][y];
                path.append(moves[d]);
                x -= dx[d];
                y -= dy[d];
            }
            out.println(path.length());
            out.println(path.reverse());
        } else {
            out.println("NO");
        }

        out.close(); 
    }

    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static boolean isBoundary(int x, int y, int n, int m) {
        return x == 0 || y == 0 || x == n - 1 || y == m - 1;
    }
}
