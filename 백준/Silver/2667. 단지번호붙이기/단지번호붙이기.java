import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> complexSizes = new ArrayList<>();
    static int complexCount = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    complexSizes.add(size);
                    complexCount++;
                }
            }
        }

        System.out.println(complexCount);

        Collections.sort(complexSizes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }
}
