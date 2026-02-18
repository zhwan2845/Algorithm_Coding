import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        int min = Integer.MAX_VALUE;
        
        for (int i = n / 5; i >= 0; i--) {
            int remain = n - i * 5;
            if (remain % 3 == 0) {
                min = i + remain / 3;
                break;
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}