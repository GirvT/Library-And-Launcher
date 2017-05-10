import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.Applet;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;

public class game4
extends Applet
implements KeyListener
{
   int points = 0;
   int lives = 3;
   public void init ()
      {
      this.addKeyListener(this);
      }   
  
   public void paint(Graphics g) 
      { 
      setSize(600, 400);
      g.setFont(new Font("Helvetica", Font.BOLD, 24)); 
      setBackground(Color.white);
      Graphics2D g2 = (Graphics2D)g;
      g.setColor(Color.black);
      g.drawString("Choose a number between 1-6", 175,100);
 
      }
   public void rando()
      {
      int randArray[]={1,2,3,4,5,6};
      Random rand = new Random();
      int  num = rand.nextInt(6)+1;
      int n = randArray[num];
      System.out.print(n);
      if (lives == 0)
         {
         System.out.print("you lost");
         }
      }

   public void keyPressed(KeyEvent e)
      {
      Random rand = new Random();
      int  num = rand.nextInt(6)+1;
      int randArray[]={1,2,3,4,5,6};
      int n = randArray[num];
      System.out.print(n);
      if (e.getKeyCode() == KeyEvent.VK_1)
         {
            if (n == 1)
               {
               points++;
               rando();
               } 
            else
               {
               lives-- ;
               rando(); 
               } 
         }
      else if (e.getKeyCode() == KeyEvent.VK_2)
         {
            if (n == 2)
               {
               points++;
               rando();
               } 
            else
               {
               lives--;  
               rando();
               } 
         }         
      else if (e.getKeyCode() == KeyEvent.VK_3)
         {
            if (n == 3)
               {
               points++;
               rando();
               } 
            else
               {
               lives--;  
               rando();
               } 
         }    

      else if (e.getKeyCode() == KeyEvent.VK_4)
         {
            if (n == 4)
               {
               points++;
               rando();
               } 
            else
               {
               lives--;  
               rando();
               } 
         }     
 
      else if (e.getKeyCode() == KeyEvent.VK_5)
         {
            if (n == 5)
               {
               points++;
               rando();
               } 
            else
               {
               lives--;  
               rando();
               } 
         }     
      else if (e.getKeyCode() == KeyEvent.VK_6)
         {
            if (n == 6)
               {
               points++;
               rando();
               } 
            else
               {
               lives--;  
               rando();
               } 
         }                                 
      else if (e.getKeyCode() == KeyEvent.VK_Q)
         {
         //frame2();
         }  
      else if (e.getKeyCode() == KeyEvent.VK_R)
         {

         }                     
         repaint();
   
      }
   
   @Override
   public void keyTyped(KeyEvent e)
      {
      }
   
   @Override
   public void keyReleased(KeyEvent e)
      {
      }   
      

}         
     
     
