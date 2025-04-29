import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int l, c;
    static char[] basket; 
    static char[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();

        basket = new char[l];
        arr = new char[c];

        for (int i = 0; i < c; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);
        backtracking(0, 0);

        sc.close();
    }

    static void backtracking(int start, int depth) {
        if (depth == l) {
            if (isValid()) {
                System.out.println(new String(basket));
            }
            return;
        }

        for (int i = start; i < c; i++) {
            basket[depth] = arr[i];
            backtracking(i + 1, depth + 1);
        }
    }

    static boolean isValid() {
        int vowel = 0;
        int consonant = 0;

        for (char ch : basket) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        return vowel >= 1 && consonant >= 2;
    }
} 