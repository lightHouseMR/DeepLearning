public class Digit {
    private byte label;
    private byte[] image;
    Digit(byte parLabel, byte[]parImage){
        label=parLabel;
        image=parImage;
    }
    public byte[] giveImage(){
        return image;
    }
    public byte giveLabel(){
        return label;
    }
}
