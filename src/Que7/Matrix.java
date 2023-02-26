package Que7;

public class Matrix extends Thread {
    private static int[][] a;
    private static int[][] b;
    private static int[][] c;


    private int i;
    private int j;
    private int z1;

    private int s;
    private int k;

    public Matrix(int[][] A, final int[][] B, final int[][] C, int i, int j, int z1) { // need to change this, might
        a = A;
        b = B;
        c = C;
        this.i = i;
        this.j = j;
        this.z1 = z1;
    }

    public void run() {
        synchronized (c) {

            for (s = 0, k = 0; k < z1; k++)
                s += a[i][k] * b[k][j];
            c[i][j] = s;
        }
    }

    public static int[][] returnC() {
        return c;
    }

    public static int[][] multiply(final int[][] a, final int[][] b) {

        final int x = a.length;
        final int y = b[0].length;

        final int z1 = a[0].length;
        final int z2 = b.length;

        if (z1 != z2) {
            System.out.println("Cannnot multiply");
            return null;
        }

        final int[][] c = new int[x][y];
        int i, j;


        for (i = 0; i < x; i++)
            for (j = 0; j < y; j++) {
                try {
                    Matrix temp_thread = new Matrix(a, b, c, i, j, z1);
                    temp_thread.start();


                    temp_thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        return Matrix.returnC();
    }
}
class Main {
    public static int[][] a = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}};

    public static int[][] b = {
            {1},
            {1},
            {1}};

    public static void print_matrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] x = Matrix.multiply(a, b);
        print_matrix(x);
    }
}