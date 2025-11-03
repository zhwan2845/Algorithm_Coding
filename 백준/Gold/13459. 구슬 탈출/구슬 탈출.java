import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n, m;
    public static char[][] board;
    public static boolean[][][][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        visited = new boolean[n][m][n][m];
        int result = solve(rx, ry, bx, by);
        System.out.println(result);
        sc.close();
    }

    public static int solve(int rx, int ry, int bx, int by) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        boolean flagR = false;
        boolean flagB = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0];
            int cry = cur[1];
            int cbx = cur[2];
            int cby = cur[3];
            int depth = cur[4];

            if (depth >= 10) {
                return 0;
            }

            for (int i = 0; i < 4; i++) {
                int nrx = crx;
                int nry = cry;
                int nbx = cbx;
                int nby = cby;
                int rMove = 0;
                int bMove = 0;

                flagR = false;
                flagB = false;

                while (nrx >= 0 && nrx < n && nry >= 0 && nry < m) {
                    int nx = nrx + dx[i];
                    int ny = nry + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != '#') {
                        nrx = nx; 
                        nry = ny; 
                        rMove++;
                    } else break;

                    if (board[nrx][nry] == 'O') {
                        flagR = true;
                        break;
                    }
                }

                while (nbx >= 0 && nbx < n && nby >= 0 && nby < m && board[nbx + dx[i]][nby + dy[i]] != '#') {
                    int nx = nbx + dx[i];
                    int ny = nby + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != '#') {
                        nbx = nx; 
                        nby = ny; 
                        bMove++;

                        if (board[nbx][nby] == 'O') {
                            flagB = true;
                            break;
                        }
                    }
                    else break;
                }

                // 파랑이 빠졌으면 이 방향 시도는 무시
                if (flagB) {
                    // 다음 방향으로
                    continue;
                }

                // 빨강만 빠졌으면 성공
                if (flagR) {
                    return 1;
                }

                // 두 구슬이 겹치면 더 많이 이동한 쪽을 한 칸 뒤로
                if (nrx == nbx && nry == nby) {
                    if (rMove > bMove) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new int[] {nrx, nry, nbx, nby, depth + 1});
                }
            }
        }
        return 0;
    }
}