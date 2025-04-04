import java.lang.reflect.Array;
import java.util.Arrays;
import  java.util.Scanner;

public class Main {


    public static  int[][] fillArrayWithValues(char name,int row, int column, Scanner scanner){
        int[][] result = new int[row][column];
        System.out.println("Please fill the array " + name + " with its values");
        for(int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                result[i][j] = scanner.nextInt();
            }
        }
        System.out.println("This is the structure of matrix "+ name + " ("+row + "x" + column+")");
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    public static int[][] multiplyMatrices(int n, int[][] A, int[][] B, int P, int m){
        if(A == null){
            System.out.println("Array A must be provided in order to proceed");
        }
        if(B == null){
            System.out.println("Array B must be provided in order to proceed");
        }
        int[][] result = new int[n][P];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < P; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }


    public static void displayResult(int[][] C, int row, int column){
        System.out.println("Result of Matrix C (" + row + "x" + column + "):");
        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < column; j++) {
                System.out.printf("%4d ", C[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;
        int m;
        int P;


        System.out.println("Please enter the number of rows of matrix A - n");
        n = scanner.nextInt();

        System.out.println("Please Enter the number of columns of A / rows of B - m");
        m = scanner.nextInt();

        System.out.println("Please Enter the number of columns of B - P");
        P = scanner.nextInt();

        int [][] A ;
        int [][] B ;
        int [][] C ;


       A = fillArrayWithValues('A',n,m,scanner);
       B = fillArrayWithValues('B',m,P,scanner);
       C = multiplyMatrices(n,A,B,P, m);
       displayResult(C,n,P);

        scanner.close();

    }
}