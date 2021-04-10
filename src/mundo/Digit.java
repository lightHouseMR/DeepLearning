package mundo;

public class Digit {
    private byte label;
    private float[] image;

    Digit(byte parLabel, byte[] parImage) {
        label = parLabel;
        image=new float[parImage.length];
        for(int i=0;i<image.length;i++){
            image[i]= (float)((parImage[i]& 0xff)/255.0);
        }
    }

    public float[] giveImage() {
        return image;
    }

    public byte giveLabel() {
        return label;
    }
}
