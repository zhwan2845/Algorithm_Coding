import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {static int n;
    static int[][] locations;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            locations = new int[n + 2][2];
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                locations[i][0] = sc.nextInt(); 
                locations[i][1] = sc.nextInt();
            }

            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }

        sc.close();
    }

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // 시작: 집 위치 인덱스 0
        visited[0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            int curX = locations[current][0];
            int curY = locations[current][1];

            // 페스티벌에 도달 가능한 경우
            if (Math.abs(curX - locations[n + 1][0]) + Math.abs(curY - locations[n + 1][1]) <= 1000) {
                return true;
            }

            // 편의점 + 페스티벌 모두 포함 (이미 visited[n + 1]은 체크 안되게 조건에 의해 걸러짐)
            for (int i = 1; i < n + 2; i++) {
                if (!visited[i]) {
                    int nextX = locations[i][0];
                    int nextY = locations[i][1];
                    if (Math.abs(curX - nextX) + Math.abs(curY - nextY) <= 1000) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }

        return false;
    }
}