import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int cnt = 0;
    static int max = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    int size = bfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dirR[i];
                int nc = cur[1] + dirC[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        size++;
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return size;
    }

    public static int dfs(int r, int c) {
        visited[r][c] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dirR[i];
            int nc = c + dirC[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    size += dfs(nr, nc);
                }
            }
        }

        return size;
    }
}
