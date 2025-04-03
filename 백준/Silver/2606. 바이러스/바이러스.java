import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);
        System.out.println(sum);
        sc.close();
    }

    public static void dfs(int v) {
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !visited[i]) {
                sum++;
                dfs(i);
            }
        }
    }
}
