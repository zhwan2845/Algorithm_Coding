import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, k;
    static boolean[] visited = new boolean[100001];
    static int[] dist = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(solve2());
        sc.close();
    }

    public static int solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        dist[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                return dist[cur];
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                q.add(cur - 1);
                visited[cur - 1] = true;
                dist[cur - 1] = dist[cur] + 1;
            }

            if (cur + 1 <= 100000 && !visited[cur + 1]) {
                q.add(cur + 1);
                visited[cur + 1] = true;
                dist[cur + 1] = dist[cur] + 1;
            }

            if (cur * 2 <= 100000 && !visited[cur * 2]) {
                q.add(cur * 2);
                visited[cur * 2] = true;
                dist[cur * 2] = dist[cur];
            }
        }

        return -1;
    }
    
    // dequeue
    public static int solve2() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(n);
        visited[n] = true;
        dist[n] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            if (cur == k) {
                return dist[cur];
            }

            if (cur * 2 <= 100000 && !visited[cur * 2]) {
                dq.addFirst(cur * 2);
                visited[cur * 2] = true;
                dist[cur * 2] = dist[cur];
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                dq.add(cur - 1);
                visited[cur - 1] = true;
                dist[cur - 1] = dist[cur] + 1;
            }

            if (cur + 1 <= 100000 && !visited[cur + 1]) {
                dq.add(cur + 1);
                visited[cur + 1] = true;
                dist[cur + 1] = dist[cur] + 1;
            }
        }

        return -1;
    }
}