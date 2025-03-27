import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int sum = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (sum < arr[i] + arr[j] + arr[k] && arr[i] + arr[j] + arr[k] <= m) {
                        sum = arr[i] + arr[j] + arr[k];
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
