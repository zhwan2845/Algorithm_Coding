import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] arr;
    public static int n;
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
    
        nQueen(0);
        System.out.println(sum);
        
        sc.close();
    }

    public static void nQueen(int depth) { // depth는 행을 의미
        if (depth == n) {
            sum++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if(isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            // 같은 열인지 확인
            if (arr[i] == arr[depth]) {
                return false;
            }

            // 같은 대각선인지 확인
            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}