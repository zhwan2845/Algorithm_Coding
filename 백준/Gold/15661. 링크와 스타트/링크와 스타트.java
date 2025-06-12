import java.util.*;

public class Main {
    static int n;
    static int[][] s;
    static boolean[] basket; // true -> 스타트, false -> 링크
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        basket = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        // 팀을 1명 ~ n-1명으로 구성 (둘 다 최소 1명 이상)
        for (int i = 1; i <= n / 2; i++) {
            solve(0, 0, i);
        }

        System.out.println(minValue);
    }

    public static void solve(int start, int depth, int m) {
        if (depth == m) {
            minValue = Math.min(diff(), minValue);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!basket[i]) {
                basket[i] = true;
                solve(i + 1, depth + 1, m);
                basket[i] = false;
            }
        }
    }

    public static int diff() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (basket[i] && basket[j]) {
                    startScore += s[i][j] + s[j][i];
                } else if (!basket[i] && !basket[j]) {
                    linkScore += s[i][j] + s[j][i];
                }
            }
        }

        return Math.abs(startScore - linkScore);
    }
}