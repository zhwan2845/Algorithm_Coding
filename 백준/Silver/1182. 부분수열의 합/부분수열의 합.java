import java.util.Scanner;

public class Main {
    static int n;
    static int s;
    static int ans = 0;
    static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        func(0, 0);

        if (s == 0) ans--;

        System.out.println(ans);
        sc.close();
    }

    static void func(int sum, int v) {
        if (v == n) {
            if (sum == s) {
                ans++;
            }
            return;
        }

        func(sum + arr[v], v + 1);
        func(sum, v + 1);
    }
} 