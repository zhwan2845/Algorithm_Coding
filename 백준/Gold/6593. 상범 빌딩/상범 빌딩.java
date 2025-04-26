import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int l, r, c;
    static char[][][] board;
    static boolean[][][] visited;
    static int[][][] dist;
    static int[] dl = {0, 0, 0, 0, -1, 1}; // 동서남북상하
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    static int max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            sc.nextLine();

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            board = new char[l][r][c];
            visited = new boolean[l][r][c];
            dist = new int[l][r][c];
            max = -1;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = sc.nextLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = s.charAt(k);
                    }
                }
                sc.nextLine();
            }
            bfs();

            boolean trapped = false;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (board[i][j][k] == 'E') {
                            trapped = true;
                        }
                        max = Math.max(max, dist[i][j][k]);
                    }
                }
            }

            if (trapped) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + max + " minute(s).");
            }
        }

        sc.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (board[i][j][k] == 'S') {
                        q.add(new int[] {i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int sl = cur[0];
            int sr = cur[1];
            int sc = cur[2];

            for (int i = 0; i < 6; i++) {
                int nl = sl + dl[i];
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if (nl >= 0 && nl < l && nr >= 0 && nr < r && nc >= 0 && nc < c) {
                    if (!visited[nl][nr][nc] && board[nl][nr][nc] == '.') {
                        q.add(new int[] {nl, nr, nc});
                        visited[nl][nr][nc] = true;
                        board[nl][nr][nc] = 'S';
                        dist[nl][nr][nc] = dist[sl][sr][sc] + 1;
                    }
                    else if (!visited[nl][nr][nc] && board[nl][nr][nc] == 'E') {
                        visited[nl][nr][nc] = true;
                        board[nl][nr][nc] = 'S';
                        dist[nl][nr][nc] = dist[sl][sr][sc] + 1;
                        return;
                    }
                }
            }
        }
    }
}
