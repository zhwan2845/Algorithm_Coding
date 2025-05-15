import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int num = 1;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int minBridge = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        // 섬 구분 짓기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    mark(i, j);
                    num += 1;
                }
            }
        }

        // 각 섬에 대해 최소 거리 탐색
        for (int i = 2; i < num; i++) {
            bfs(i);
        }

        System.out.println(minBridge);
        sc.close();
    }

    public static void mark(int sr, int sc) {
        Queue <int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        visited[sr][sc] = true;
        map[sr][sc] = num;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if(!visited[nr][nc] && map[nr][nc] == 1) {
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        map[nr][nc] = num;
                    }
                }
            }
        }
    }
    
    public static void bfs(int num) {
        Queue <int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == num) { // 바다가 아니면
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] ) {
                    if (map[nr][nc] != num && map[nr][nc] != 0) {
                        minBridge = Math.min(minBridge, dist[cur[0]][cur[1]]);
                        return;
                    }

                    if (map[nr][nc] == 0) {
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}