package interfaz;

import javax.swing.JFrame;
import java.awt.*;

import mundo.Digit;

public class ShowImage extends JFrame {

    private static final long serialVersionUID = 1L;
    private static int windowX = 300;
    private static int windowY = 300;

    Digit dig;
    int xSize;
    int ySize;

    public ShowImage() {
        setSize(windowX, windowY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void show(Digit pDig, int pXSize, int pYSize) {
        dig = pDig;
        xSize = pXSize;
        ySize = pYSize;
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(0));
        float[] digito=dig.giveImage();
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                int color = (int)(digito[i * ySize + j] *255);
                g2D.setPaint(new Color(color, color, color));
                g2D.fillRect(windowX * j / xSize, windowY * i / ySize, windowX / xSize + 1, windowY / xSize + 1);
            }
        }
    }

}
