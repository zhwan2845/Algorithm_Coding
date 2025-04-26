import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int m, n, h;
    static int[][][] board;
    static boolean[][][] visited;
    static int[][][] dist;
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int max = -1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        board = new int[h][n][m];
        visited = new boolean[h][n][m];
        dist = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = sc.nextInt();
                }
            }
        }
        
        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, dist[i][j][k]);
                }
            }
        }
        System.out.println(max);
        sc.close();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 1) {
                        q.add(new int[] {i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int r = cur[1];
            int c = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nz < h && nz >= 0 && nr < n && nr >= 0 && nc < m && nc >= 0) {
                    if (!visited[nz][nr][nc] && board[nz][nr][nc] == 0) {
                        q.add(new int[] {nz, nr, nc});
                        board[nz][nr][nc] = 1;
                        visited[nz][nr][nc] = true;
                        dist[nz][nr][nc] = dist[z][r][c] + 1;
                    }
                }
            }
        }
    }
}
