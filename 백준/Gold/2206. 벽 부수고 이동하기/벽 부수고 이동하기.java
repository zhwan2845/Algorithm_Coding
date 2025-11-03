import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        solve();

        int a = visited[n - 1][m - 1][0];
        int b = visited[n - 1][m - 1][1];

        int ans;
        if (a == 0 && b == 0) ans = -1;
        else if (a == 0) ans = b;
        else if (b == 0) ans = a;
        else ans = Math.min(a, b);

        System.out.println(ans);
        sc.close();
    }

    public static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0}); // 현재 행, 현재 열, 해당 위치에 도달하기까지 벽을 부쉈는가?(O: 1, X: 0)
        visited[0][0][0] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cw = cur[2]; 

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    // case 1: 다음 이동할 곳이 벽이라면, 벽을 부수는게 가능하면 -> 벽을 부순다.
                    // case 2: 다음 이동할 곳이 벽이라면, 벽을 부수는게 가능X -> 벽을 못부순다. (구현 안해도 됨)
                    if (map[nr][nc] == 1 && cw == 0 && visited[nr][nc][1] == 0) {
                        visited[nr][nc][1] = visited[cr][cc][cw] + 1;
                        q.add(new int[] {nr, nc, 1});
                    }
                    // 다음 이동할 곳이 벽이 아닌 경우,
                    if (map[nr][nc] == 0 && visited[nr][nc][cw] == 0) {
                        visited[nr][nc][cw] = visited[cr][cc][cw] + 1;
                        q.add(new int[] {nr, nc, cw});
                    }
                }
            }
        }
    }
}