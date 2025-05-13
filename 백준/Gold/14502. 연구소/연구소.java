import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};
    static int maxSafeZone = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();

        backtracking(0);
        System.out.println(maxSafeZone);
        sc.close();
    }

    public static void backtracking(int depth) {
        if (depth == 3) {
            int[][] temp = copyMap(); // map 복사
            visited = new boolean[n][m]; // 방문 초기화
            bfs(temp);
            calSafeZone(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtracking(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(int[][] temp) {
        Queue <int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
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
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && temp[nr][nc] == 0) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    temp[nr][nc] = 2;
                }
            }
        }
    }

    public static void calSafeZone(int[][] temp) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (temp[i][j] == 0)
                    count++;

        maxSafeZone = Math.max(maxSafeZone, count);
    }

    public static int[][] copyMap() {
        int[][] copied = new int[n][m];
        for (int i = 0; i < n; i++)
            copied[i] = map[i].clone();
        return copied;
    }
}