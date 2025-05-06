import java.util.Scanner;

public class Main {
    static int n;
    static int[] operand;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        operand = new int[n];
        operator = new int[4];

        for (int i = 0; i < n; i++) {
            operand[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        backtracking(1, operand[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void backtracking(int depth, int result) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                int next = 0;
                switch (i) {
                    case 0:
                        next = result + operand[depth];
                        break;
                    case 1:
                        next = result - operand[depth];
                        break;
                    case 2:
                        next = result * operand[depth];
                        break;
                    case 3:
                        if (result < 0) {
                            next = -(-result / operand[depth]);
                        } else {
                            next = result / operand[depth];
                        }
                        break;
                }

                backtracking(depth + 1, next);
                operator[i]++;
            }
        }
    }
}
