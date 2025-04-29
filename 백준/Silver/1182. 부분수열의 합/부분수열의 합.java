import java.util.Scanner;

public class Main {
    static int n, s;
    static int[] basket;
    static int[] arr;
    static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        basket = new int[n];

        for (int i = 1; i <= n; i++) {
            backtracking(0, 0, i);
        }

        System.out.println(count);
        sc.close();
    }

    static void backtracking(int start, int depth, int size) {
        if (depth == size) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += basket[i];
            }

            if (sum == s) {
                count++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            basket[depth] = arr[i];
            backtracking(i + 1, depth + 1, size);
        }
    }
} 