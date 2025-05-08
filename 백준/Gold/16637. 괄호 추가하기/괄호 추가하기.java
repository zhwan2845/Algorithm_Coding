import java.util.Scanner;

public class Main {
    static int n;
    static char[] formula;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        formula = sc.next().toCharArray();

        func(0, formula[0] - '0');
        System.out.println(max);
    }

    public static void func(int idx, int result) {
        if (idx >= n - 1) {
            max = Math.max(max, result);
            return;
        }

        // 1. 괄호 없이 계산
        int a = result;
        char op = formula[idx + 1];
        int b = formula[idx + 2] - '0';
        int calc = cal(a, op, b);
        func(idx + 2, calc);

        // 2. 괄호 먼저 계산 가능한 경우
        if (idx + 4 < n) {
            int first = formula[idx + 2] - '0';
            char nextOp = formula[idx + 3];
            int second = formula[idx + 4] - '0';
            int temp = cal(first, nextOp, second); // 괄호 먼저
            int total = cal(result, formula[idx + 1], temp);
            func(idx + 4, total);
        }
    }

    public static int cal(int a, char op, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0; // 도달 x
    }
}
