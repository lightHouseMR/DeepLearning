package mundo;

public class DeepLearning {
    DataSet train;
    DataSet test;
    final String[] labels={
    "T-shirt/top"
    ,"Trouser"
    ,"Pullover"
    ,"Dress"
    ,"Coat"
    ,"Sandal"
    ,"Shirt"
    ,"Sneaker"
    ,"Bag"
    ,"Ankle boot"};

    public void run() {
        try {
            train = new DataSet("data/train-images-idx3-ubyte", "data/train-labels-idx1-ubyte");
            test = new DataSet("data/t10k-images-idx3-ubyte", "data/t10k-labels-idx1-ubyte");
            printInfo();
            //test.showImages();
            int[] layers = { 784, 16, 16, 10 };
            NeuralNetwork network = new NeuralNetwork(layers);
            float[]output =network.runNetwork(train.giveDigits()[0].giveImage());
            for(int i=0;i<output.length;i++){
                System.out.println(labels[i]+": "+output[i]*100);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printInfo() {
        System.out.println("Train | DataSize: " + train.giveDataSize() + ", Magic: " + train.magicNumbers());
        System.out.println("Test | DataSize: " + test.giveDataSize() + ", Magic: " + test.magicNumbers());
    }

}
