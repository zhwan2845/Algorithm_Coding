import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, l;
    static int startR, startC, endR, endC;
    static char[][] board;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dr = {-2, -2, 2, 2, 1, -1, -1, 1}; // 상하좌우(좌우)
    static int[] dc = {-1, 1, -1, 1, -2, -2, 2, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            l = sc.nextInt();

            board = new char[l][l];
            visited = new boolean[l][l];
            dist = new int[l][l];

            startR = sc.nextInt();
            startC = sc.nextInt();

            endR = sc.nextInt();
            endC = sc.nextInt();

            bfs();
            System.out.println(dist[endR][endC]);
        }

        sc.close();
    }
    
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startR, startC});
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == endR && c == endC) return;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < l && nc >= 0 && nc < l && !visited[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                }
            }
        }
    }
}
