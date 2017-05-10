import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.Applet;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class game3
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
      Graphics2D g2 = (Graphics2D)g;
      g2.fill(rect);
      setSize(600, 400);
      g.setFont(new Font("Helvetica", Font.BOLD, 24)); 
      g.setColor(Color.red);  
      g.fillRect(540,340,50,200);
      g.setColor(Color.blue);
      g.fillRect(0,250,540,300);
      g.setColor(Color.blue);
      g.fillRect(50,0,300,200);
      g.setColor(Color.blue);
      g.fillRect(400,50,140,200);
      g.setColor(Color.blue);
      g.fillRect(590,0,200,500);
      setBackground(Color.white);
      
      g.setColor(Color.black);
      g.drawString("Move to the red square.", 70,100);
      g.drawString("Don't touch the blue or fall off the platform", 20,350);
      if (rect.x==540 && rect.y==340)
         {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.BLACK);
         g.drawString("You Win!", 255,100);
         g.drawString("Press Q to quit, R to restart", 150,150);
         
         }
         else if (rect.x<500 && rect.y>200)
            {
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
             
            }
         else if (rect.x>0 && rect.y<200 && rect.x<350)
            {
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
            
            }
         else if (rect.x>350 && rect.y>0 && rect.x<540)
            {
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
           
            }
         else if (rect.x<0 || rect.y<0)
            {
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
            
            }
         else if (rect.x>540)
            {
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
            
            }

         
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
     
     