package mundo;

public class DeepLearning {
    DataSet train;
    DataSet test;

    public void run() {
        try {
            train = new DataSet("data/train-images-idx3-ubyte", "data/train-labels-idx1-ubyte");
            test = new DataSet("data/t10k-images-idx3-ubyte", "data/t10k-labels-idx1-ubyte");
            printInfo();
            // test.showImages();
            int[] layers = { 784, 16, 16, 10 };
            NeuralNetwork network = new NeuralNetwork(layers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printInfo() {
        System.out.println("Train | DataSize: " + train.giveDataSize() + ", Magic: " + train.magicNumbers());
        System.out.println("Test | DataSize: " + test.giveDataSize() + ", Magic: " + test.magicNumbers());
    }

}
