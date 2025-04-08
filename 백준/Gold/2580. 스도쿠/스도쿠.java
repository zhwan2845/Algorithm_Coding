import java.util.Scanner;

public class Main {
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        sudoku(0, 0);
        System.out.println();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                    arr[row][col] = 0;
                }
            }
        } else {
            sudoku(row, col + 1);
        }
    }

    public static boolean isPossible(int row, int col, int value) {
        // 1) 같은 행에 value가 있는지 없는지 검사
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }
        // 2) 같은 열에 value가 있는지 없는지 검사
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        // 3) 3*3에 value가 있는지 없는지 검사
        int start_row = (row / 3) * 3;
        int start_col = (col / 3) * 3;

        for (int i = start_row; i < start_row + 3; i += 1) {
            for (int j = start_col; j < start_col + 3; j += 1) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}