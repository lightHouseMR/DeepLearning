package mundo;

public final class NeuralMath {
    public static int[][] fastMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[] fastMultiply(int[][] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                C[i] += A[i][k] * B[k];
            }
        }
        return C;
    }
}
