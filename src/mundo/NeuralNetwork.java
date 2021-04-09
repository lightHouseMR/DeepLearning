package mundo;

public class NeuralNetwork {
    float[][] layers;
    float[][][] weights;
    float[][] bias;
    public NeuralNetwork(int[] pLayers) {
        //Initialize layers
        layers=new float[pLayers.length][];
        for(int i=0;i<pLayers.length;i++){
            layers[i]=new float[pLayers[i]];
        }
        //Initialize weights
        weights=new float[pLayers.length-1][][];
        for(int i=0;i<weights.length;i++){
            weights[i]=new float[pLayers[i+1]][pLayers[i]];
            int antSize=pLayers[i];
            int sigSize=pLayers[i+1];
            for(float[] currWeights:weights[i]){
                for(float weight:currWeights){
                    double random = antSize + Math.random() * (sigSize - antSize);
                    weight=(float)(random*Math.sqrt(2/antSize));
                }
            }
        }
        //Initialize bias
        bias=new float[pLayers.length-1][];
        for(int i=0;i<bias.length;i++){
            bias[i]=new float[pLayers[i+1]];
            for(float bia:bias[i]){
                bia=0;
            }
        }
    }

}
