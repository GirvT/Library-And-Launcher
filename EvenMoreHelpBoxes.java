//Author: Keith Chow
//Date : 08/06/17

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
@author Keith Chow
"EvenMoreHelpBoxes" class when called draws a frame with images that have helpful information when operating the main GUI
*/
public class EvenMoreHelpBoxes
{
   /**
   "moreHelpBoxes" creates an array that has refrences to all the help image filenames and calls a specific 
   one based on which x is called
   @param x is the number of the help image that is needed to be called
   0 is assistance with the Add function
   1 is assistance with the Delete function
   2 is assistance with the Launch function
   3 is assistance with the Refresh function
   4 is assistance with the Sort function
   5 is assistance with the Search function
   */
   public void moreHelpBoxes(int x)
      {  
         String images[] = {"addHelp.png", "deleteHelp.png", "launchHelp.png", "refreshHelp.png", "sortHelp.png", "searchHelp.png"};
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