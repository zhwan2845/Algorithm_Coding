import java.util.Scanner;

public class Main {
    static int k;
    static int[] s;
    static int[] lotto;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) break;

            s = new int[k];
            lotto = new int[6];

            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }

            backtracking(0, 0);
            System.out.println();
        }
    }

    public static void backtracking(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            lotto[depth] = s[i];
            backtracking(depth + 1, i + 1);
        }
    }
}