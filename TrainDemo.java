import javax.swing.*;
import java.awt.*;

public class TrainDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Train Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new TrainCanvas());
        frame.setVisible(true);
    }

}

class TrainCanvas extends JComponent {

    private int lastX = 0;
    private int lastA = 0;

    public TrainCanvas() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });

        animationThread.start();
    }

    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        int trainW = 10;
        int trainH = 20;
        int trainQ = 30;
        int trainE = 10;
        int trainSpeed = 2;

        int x = lastX + trainSpeed;
        trainSpeed = 5;
        int a = lastA + trainSpeed;

        if (x > w + trainW || a > w + trainQ) {
            x = -trainW;
            a = -trainQ;
        }

        gg.setColor(Color.BLACK);
        gg.fillRect(x, h/2 + trainH, trainW, trainH);
        gg.setColor(Color.BLUE);
        gg.fillRect(x, h/2 + trainH, trainQ, trainE);
        

        lastX = x;
        lastA = a;
    }

}