import java.util.Scanner;

public class Main {
    static int k;
    static char[] signs;
    static int[] basket;
    static boolean[] visited = new boolean[10];
    static String max = "";
    static String min = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];

        for (int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        for(int i = 0; i < 10; i++) {
            visited[i] = true;
            backtracking(0, i, i + "");
            visited[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void backtracking(int depth, int prev, String nums) {
        if (depth == k) {
            // nums를 이용해서 최댓값 최솟값 갱신하기
            if (min.equals("") || nums.compareTo(min) < 0) {
                min = nums;
            }
            if (max.equals("") || nums.compareTo(max) > 0) {
                max = nums;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (signs[depth] == '<' && prev < i || signs[depth] == '>' && prev > i) {
                    visited[i] = true;
                    backtracking(depth + 1, i, nums + i);
                    visited[i] = false;
                }
            }
        }
    }
}