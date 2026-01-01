import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (nextPermutation()) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println(-1);
        }

        sc.close();
    }

    static boolean nextPermutation() {
        int i = n - 1;

        // 1. 뒤에서부터 감소하는 지점 찾기
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) return false;

        // 2. 교환할 값 찾기
        int j = n - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        // 3. swap
        swap(i - 1, j);

        // 4. 뒤쪽 정렬 (reverse)
        int k = n - 1;
        while (i < k) {
            swap(i, k);
            i++;
            k--;
        }

        return true;
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}