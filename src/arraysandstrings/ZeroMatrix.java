package arraysandstrings;

import java.util.Scanner;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to O.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        nullifyMatrix(matrix);
    }

    private static void nullifyMatrix(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        //nullify rows
        for (int i = 0; i < rows.length;i++){
            if (rows[i]) nullifyRows(matrix,i);
        }

        //nullify columns
        for (int i = 0; i < cols.length; i++){
            if (cols[i]) nullifyColumns(matrix,i);
        }

        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    private static void nullifyColumns(int[][] matrix, int col) {
        for (int i = 0; i < matrix[0].length;i++){
            matrix[i][col] = 0;
        }
    }

    private static void nullifyRows(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length;i++){
            matrix[row][i] = 0;
        }
    }


}
