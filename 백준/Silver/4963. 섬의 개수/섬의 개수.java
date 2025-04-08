import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int w, h;
    static int[][] board;
    static boolean[][] visited;
    static int[] dirR = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dirC = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt;
        w = sc.nextInt();
        h = sc.nextInt();

        while (w != 0 && h != 0) {
            cnt = 0;
            
            board = new int[h][w];
            visited = new boolean[h][w];
            
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    board[r][c] = sc.nextInt();
                }
            }

            for(int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (!visited[r][c] && board[r][c] == 1) {
                        dfs(r, c);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

            w = sc.nextInt();
            h = sc.nextInt();
        }
    
        sc.close();
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dirR[i];
            int nc = c + dirC[i];
            if (nr < h && nr >= 0 && nc < w && nc >= 0 && !visited[nr][nc] && board[nr][nc] == 1) {
                dfs(nr, nc);
            } 
        }
    } 

    // bfs
    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 8; i++) {
                int nr = cr + dirR[i];
                int nc = cc + dirC[i];

                if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                    if (!visited[nr][nc] && board[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
    }
}
