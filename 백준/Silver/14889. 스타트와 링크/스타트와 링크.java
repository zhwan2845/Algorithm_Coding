import java.util.Scanner;

public class Main {
    static int n;
    static int[] basketA;
    static int[] basketB;
    static int[][] ability;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n][n];
        basketA = new int[n / 2];
        basketB = new int[n / 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ability[i][j] = sc.nextInt();
            }
        }

        backtracking(0, 0);
        System.out.println(minDiff);
        sc.close();
    }

    public static void backtracking(int start, int depth) {
        if (depth == n / 2) {
            int diff = cal();
            if(diff < minDiff) {
                minDiff = diff;
            }
            return;
        }
        
        for (int i = start; i < n; i++) {
            basketA[depth] = i;
            backtracking(i + 1, depth + 1);
        }
    }

    public static int cal() {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            boolean inBasketA = false;
            for (int j = 0; j < n / 2; j++) {
                if(basketA[j] == i) {
                    inBasketA = true;
                    break;
                }
            }
            if (!inBasketA) {
                basketB[idx] = i;
                idx++;
            }
        }
        
        int scoreA = 0;
        int scoreB = 0;
        
        for (int i = 0; i < basketA.length; i++) {
            for (int j = i + 1; j < basketA.length; j++) {
                scoreA += ability[basketA[i]][basketA[j]] + ability[basketA[j]][basketA[i]];
            }
        }
        
        for (int i = 0; i < basketB.length; i++) {
            for (int j = i + 1; j < basketB.length; j++) {
                scoreB += ability[basketB[i]][basketB[j]] + ability[basketB[j]][basketB[i]];
            }
        }
        
        return Math.abs(scoreA - scoreB);
    }
}
