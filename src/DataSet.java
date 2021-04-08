
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DataSet {

    private Digit[] digits;
    private int magicImage;
    private int magicLabel;
    private int dataSize;
    private int xSize;
    private int ySize;

    DataSet(String imagePath,String labelPath) throws Exception{
        byte[] images = Files.readAllBytes(Paths.get(imagePath));
        byte[] labels = Files.readAllBytes(Paths.get(labelPath));
        magicImage=byteToInt(images[0], images[1], images[2], images[3]);
        magicLabel=byteToInt(labels[0], labels[1], labels[2], labels[3]);
        dataSize=byteToInt(images[4], images[5], images[6], images[7]);
        if(dataSize!=byteToInt(labels[4], labels[5], labels[6], labels[7])){
            throw new Exception("Data size discrepancy");
        }
        xSize=byteToInt(images[8], images[9], images[10], images[11]);
        ySize=byteToInt(images[12], images[13], images[14], images[15]);
        digits=new Digit[dataSize];
        int i;
        for(i=0;i<dataSize;i++){
            byte[] bitmap=Arrays.copyOfRange(images,i*xSize*ySize+16,(i+1)*xSize*ySize+16);
            digits[i]=new Digit(labels[i+8], bitmap);
        }
    }

    public int byteToInt(byte a,byte b,byte c,byte d) {
        return ((a & 0xFF) << 24) |
                ((b & 0xFF) << 16) |
                ((c & 0xFF) << 8) |
                ((d & 0xFF) << 0);
    }

    public void showImage(int pDig){
        ShowImage window=new ShowImage();
        window.show(digits[pDig],xSize,ySize);
    }

    public void showImages() throws InterruptedException{
        ShowImage window=new ShowImage();
        for(int i=0;i<digits.length;i++){
            window.show(digits[i],xSize,ySize);
            TimeUnit.MILLISECONDS.sleep(500);
            //TODO: Threads
        }
    }

    public String magicNumbers(){
        return magicImage+" "+magicLabel;
    }

    public int giveDataSize(){
        return dataSize;
    }

}