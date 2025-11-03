import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
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

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0], cry = cur[1];
            int cbx = cur[2], cby = cur[3];
            int depth = cur[4];
            
            if (depth >= 10) {
                return -1;
            }

            for (int dir = 0; dir < 4; dir++) {
                int[] nextRed = move(crx, cry, dir);
                int[] nextBlue = move(cbx, cby, dir);
                
                int nrx = nextRed[0], nry = nextRed[1], rMove = nextRed[2];
                int nbx = nextBlue[0], nby = nextBlue[1], bMove = nextBlue[2];

                // 파란색 구슬이 빠졌는지 확인                
                if (board[nbx][nby] == 'O') { 
                    continue;
                }
                // 빨간색 구슬이 빠졌는지 확인
                if (board[nrx][nry] == 'O') {
                    return depth + 1;
                }
                // 빨간색 구슬이 안빠졌다면
                // 빨간색 구슬과 파란색 구슬이 같은 위치에 있는 경우
                if (nrx == nbx && nry == nby) {
                    if (rMove >= bMove) {
                        nrx = nrx - dx[dir];
                        nry = nry - dy[dir];
                    } else {
                        nbx = nbx - dx[dir];
                        nby = nby - dy[dir];
                    }
                }
                if (!visited[nrx][nry][nbx][nby]) {
                    q.add(new int[] {nrx, nry, nbx, nby, depth + 1});
                    visited[nrx][nry][nbx][nby] = true;
                }
            }
        }
        return -1;
    }

    public static int[] move(int row, int col, int direction) {
        int cnt = 0;
        while (true) {
            int nr = row + dx[direction];
            int nc = col + dy[direction];
    
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) break;
            if (board[nr][nc] == '#') break;
    
            row = nr;
            col = nc;
            cnt++;
    
            if (board[row][col] == 'O') break;
        }
        return new int[] {row, col, cnt};
    }
}