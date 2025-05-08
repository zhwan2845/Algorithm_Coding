import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static String[] word; // 입력 받는 것
    static ArrayList<Character> list = new ArrayList<>(); // ['A', 'C', 'D', 'E', 'F', 'G']
    static int[] digit; // [1, 2, 3, 4, 5, 6]
    static boolean[] visited = new boolean[10];
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = sc.next();
            for (char c : word[i].toCharArray()) {
                if (!list.contains(c)) {
                    list.add(c);
                }
            }
        }

        digit = new int[list.size()];
        backtracking(0);
        System.out.println(max);
        sc.close();
        
    }

    public static void backtracking(int depth) {
        if (depth == list.size()) {
            int sum = 0;
            for (String w : word) {
                int val = 0;
                for (char c : w.toCharArray()) {
                    int idx = list.indexOf(c);
                    val = val * 10 + digit[idx];
                }
                sum += val;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int num = 0; num < 10; num++) {
            if (!visited[num]) {
                visited[num] = true;
                digit[depth] = num;
                backtracking(depth + 1);
                visited[num] = false;
            }
        }
    }
}