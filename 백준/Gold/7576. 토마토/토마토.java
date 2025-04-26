import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] dist;
    static int max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][j]);
            }
        }
        System.out.println(max);

        sc.close();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nc = c + dc[i];
                int nr = r + dr[i];

                if (nc >= 0 && nc < m && nr >= 0 && nr < n) {
                    if (!visited[nr][nc] && board[nr][nc] == 0) {
                        q.add(new int[] {nr, nc});
                        board[nr][nc] = 1;
                        visited[nr][nc] = true;
                        dist[nr][nc] = dist[r][c] + 1;
                    }
                }
            }
        }
    }
}