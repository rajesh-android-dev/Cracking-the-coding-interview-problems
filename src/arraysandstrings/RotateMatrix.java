package arraysandstrings;

import java.util.Scanner;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
 */
public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j =0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        rotateMatrix(matrix);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length != matrix.length){
            System.out.println("Not a valid matrix");
        }
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++){
                int offset = i - first;

                int top = matrix[first][i]; //save top

                //left -> top
                matrix[first][i] = matrix[last-offset][first];

                //bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                //right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top; //right <- saved top
            }
        }
        return matrix;
    }
}
