import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] basket;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        basket = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0);

        System.out.print(sb.toString());
    }

    static void backTracking(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(basket[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1; // 이전에 사용한 숫자 (중복 수열 방지)

        for (int i = 0; i < n; i++) {
            // 이미 사용한 원소이거나, 같은 depth에서 이전에 사용한 값이면 넘어가기
            if (visited[i] || arr[i] == prev) {
                continue;
            }

            visited[i] = true;
            basket[depth] = arr[i];
            prev = arr[i];

            backTracking(depth + 1);

            visited[i] = false;
        }
    }
}
