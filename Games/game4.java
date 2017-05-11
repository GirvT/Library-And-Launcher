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
   int lives = 5;
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
      g.drawString("Choose a number between 1-6", 130,120);
      g.drawString("Wrong guess = lose a life", 160,160);
      g.drawString("Right guess = gain a life", 175,190);
      g.drawString("Lives remaining = " + lives, 350,40);
      if (lives<=0)
         {
         g.clearRect(0, 0, getWidth(), getHeight()); 
         g.setColor(Color.black);
         g.drawString("You Lost!", 265,40);
         g.drawString("Press Q to exit the game, press R to restart", 60,75);
         }
 
      }
   public void rando()
      {
      int randArray[]={1,2,3,4,5,6};
      Random rand = new Random();
      int  num = rand.nextInt(6);
      int n = randArray[num];
      if (lives >= 0)
         {
         repaint();  
         }
      }   

   public void keyPressed(KeyEvent e)
      {
      Random rand = new Random();
      int  num = rand.nextInt(6);
      int randArray[]={1,2,3,4,5,6};
      int n = randArray[num]; 
      System.out.print("  ");
      System.out.println(n);
       
      if (e.getKeyCode() == KeyEvent.VK_1)
         {
            if (n == 1)
               {
               lives++;
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
            else
               {
               lives--;  
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
         }        
      else if (e.getKeyCode() == KeyEvent.VK_2)
         {
            if (n == 2)
               {
               lives++;
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
            else
               {
               lives--;  
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
         }        
      else if (e.getKeyCode() == KeyEvent.VK_3)
         {
            if (n == 3)
               {
               lives++;
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
            else
               {
               lives--;  
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
         }
      else if (e.getKeyCode() == KeyEvent.VK_4)
         {
            if (n == 4)
               {
               lives++;
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
            else
               {
               lives--;  
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
         }             
      else if (e.getKeyCode() == KeyEvent.VK_5)
         {
            if (n == 5)
               {
               lives++;
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
            else
               {
               lives--;  
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
         }     
      else if (e.getKeyCode() == KeyEvent.VK_6)
         {
            if (n == 6)
               {
               lives++;
               rando();
               } 
            else
               {
               lives--;  
               System.out.println("Lives remaining:" + lives);
               rando();
               } 
         }                                 
      else if (e.getKeyCode() == KeyEvent.VK_Q)
         {
         //frame2();
         }  
      else if (e.getKeyCode() == KeyEvent.VK_R)
         {
         lives = 5;
         repaint();
         }                     
         
         
   
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
     
     