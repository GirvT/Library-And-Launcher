import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EvenMoreHelpBoxes
{
   public void moreHelpBoxes(int x)
      {  
         String images[] = {"addHelp.png", "deleteHelp.png", "launch.jpg", "refresh.jpg", "sort.jpg", "search.jpg"};
         JFrame helpFrame = new JFrame();  
         String image = images[x-1];
         System.out.print(image);
         ImageIcon icon = new ImageIcon(image);
         JLabel label = new JLabel(icon);
         helpFrame.add(label);
         helpFrame.pack();        
         helpFrame.setVisible(true);                                        
      }
}