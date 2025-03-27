import java.util.Scanner;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        
        sc.close();
        backTracking(0, "");
        
        System.out.print(sb);
    }
    
    public static void backTracking(int depth, String sequence) {
        if (depth == m) {
            sb.append(sequence).append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            backTracking(depth + 1, sequence + i + " ");
        }
    }
}
