import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static ArrayList<Integer> basket = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        
        sc.close();
        backTracking(1);
    }
    
    public static void backTracking(int start) {
        if (basket.size() == m) {
            for (int num : basket) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n + 1; i++) {
            basket.add(i);
            backTracking(i);
            basket.remove(basket.size() - 1);
        }
    }
}