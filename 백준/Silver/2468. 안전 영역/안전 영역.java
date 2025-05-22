import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        int maxHeight = 0;

        // 입력 및 최고 높이 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        int maxSafeArea = 0;

        for (int height = 0; height <= maxHeight; height++) {
            visited = new boolean[n][n];
            int safeAreaCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] > height) {
                        bfs(height, i, j);
                        safeAreaCount++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
        }

        System.out.println(maxSafeArea);
    }

    public static void bfs(int height, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!visited[nr][nc] && board[nr][nc] > height) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}