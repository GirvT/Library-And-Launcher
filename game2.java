import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.Applet;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class game2
extends Applet
implements KeyListener
{
      
   private Rectangle rect; 

   public void init()
      {
      this.addKeyListener(this);
      rect = new Rectangle (0, 0, 50, 50);
      
      }   
  
   public void paint(Graphics g)
      { 
      int a = 100;
      int b = 100;
      Timer timer = new Timer();
      
      setSize(600, 400);
      g.setFont(new Font("Helvetica", Font.BOLD, 24)); 
      g.setColor(Color.red);  
      g.drawRect(540,340,50,50);
      g.setColor(Color.blue);
      g.drawRect(0,150,500,300);
      g.setColor(Color.blue);
      g.drawRect(a,b,50,50);
      setBackground(Color.white);
      Graphics2D g2 = (Graphics2D)g;
      g.setColor(Color.black);
      g2.fill(rect);
      g.drawString("Move to the red square.", 175,100);
      g.drawString("Don't try crossing me >:(", 150,250);
      if (rect.x==540 && rect.y==340)
         {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.BLACK);
         g.drawString("You Win!", 240,100);
         g.drawString("Press R to play again", 180,150);
         
         }
         
         else if (rect.x>a-50 && rect.y>b-50 && rect.y<b+50 && rect.x<a+50)
         {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.BLACK);
         g.drawString("You Lose! Press R to restart", 140,100);  
         }
         /*else if (rect.x<a+99 && rect.y<99)
         {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.BLACK);
         g.drawString("You Lose! Press R to restart", 140,100); 
         }
         else if (rect.x>a+99 && rect.y>99)
         {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.BLACK);
         g.drawString("You Lose! Press R to restart", 140,100); 
         }*/
      }

   @Override
   public void keyPressed(KeyEvent e)
      {
      if (e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            rect.setLocation(rect.x+5, rect.y);
         }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            rect.setLocation(rect.x-5, rect.y);
         }         
      else if (e.getKeyCode() == KeyEvent.VK_UP)
         {
            rect.setLocation(rect.x, rect.y-5);
         }     
      else if (e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            rect.setLocation(rect.x, rect.y+5);
         } 
      else if (e.getKeyCode() == KeyEvent.VK_Q)
         {
         //   frame2();
         }  
      else if (e.getKeyCode() == KeyEvent.VK_R)
         {
            rect.setLocation(0, 0);
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
     
     