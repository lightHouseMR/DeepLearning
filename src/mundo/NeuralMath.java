package mundo;

public final class NeuralMath {
    public static int[][] Multiply(int[][] A, int[][] B) {
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

    public static float[] Multiply(float[][] A, float[] B) {
        int n = A.length;
        float[] C = new float[n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < B.length; k++) {
                C[i] += A[i][k] * B[k];
            }
        }
        return C;
    }

    public static float[] Sum(float[] A, float[] B) {
        float[] C = new float[A.length];
        for(int i=0;i<A.length;i++){
            C[i]=A[i]+B[i];
        }
        return C;
    }

    public static float[] ReLU(float[]A){
        float[] C = new float[A.length];
        for(int i=0;i<A.length;i++){
            C[i]=Math.max(A[i],0);
        }
        return C;
    }

}
