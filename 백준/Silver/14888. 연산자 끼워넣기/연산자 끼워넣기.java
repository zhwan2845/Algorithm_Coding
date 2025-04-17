import java.util.Scanner;
public class Main {
    public static int n;
    public static int[] arr;
    public static int[] operator = new int[4];
    public static char[] basket;
    static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        basket = new char[n - 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        cal(0);

        System.out.println(max);
        System.out.println(min);

        sc.close();
    }

    public static void cal(int depth) {
        if (depth == n - 1) {
            int result = arr[0];
            for (int i = 0; i < n - 1; i++) {
                switch (basket[i]) {
                    case '+':
                        result += arr[i + 1];
                        break;
                    case '-':
                        result -= arr[i + 1];
                        break;
                    case '*':
                        result *= arr[i + 1];
                        break;
                    case '/':
                        if (result < 0) {
                            result = -(-result / arr[i + 1]);
                        } else {
                            result = result / arr[i + 1];
                        }
                        break;
                }
            }

            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        basket[depth] = '+';
                        break;
                    case 1:
                        basket[depth] = '-';
                        break;
                    case 2:
                        basket[depth] = '*';
                        break;
                    case 3:
                        basket[depth] = '/';
                        break;
                }

                cal(depth + 1);
                operator[i]++;
            }
        }
    }
}