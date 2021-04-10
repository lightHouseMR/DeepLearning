package mundo;

public class NeuralNetwork {
    float[][] layers;
    float[][][] weights;
    float[][] bias;

    public NeuralNetwork(int[] pLayers) {
        // Initialize layers
        layers = new float[pLayers.length][];
        for (int i = 0; i < pLayers.length; i++) {
            layers[i] = new float[pLayers[i]];
        }
        // Initialize weights
        weights = new float[pLayers.length - 1][][];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = new float[pLayers[i + 1]][pLayers[i]];
            int antSize = pLayers[i];
            int sigSize = pLayers[i + 1];
            for (int j=0;j<weights[i].length;j++) {
                for (int k=0;k<weights[i][j].length;k++) {
                    //He initialization
                    double random = antSize + Math.random() * (sigSize - antSize);
                    weights[i][j][k] = (float) (random * Math.sqrt(2.0 / antSize));
                }
            }
        }
        // Initialize bias
        bias = new float[pLayers.length - 1][];
        for (int i = 0; i < bias.length; i++) {
            bias[i] = new float[pLayers[i + 1]];
        }
    }

    public float[] runNetwork(float[] input){
        layers[0]=input;
        for(int i=0;i<layers.length-1;i++){
            layers[i+1]=NeuralMath.ReLU(NeuralMath.Sum(NeuralMath.Multiply(weights[i], layers[i]),bias[i]));
        }
        float[] resp=new float[layers[layers.length-1].length];
        float sum=0;
        for(int j=0;j<layers[layers.length-1].length;j++){
            sum+=layers[layers.length-1][j];
        }
        for(int k=0;k<layers[layers.length-1].length;k++){
            resp[k]=layers[layers.length-1][k]/sum;
        }
        return resp;
    }

}
