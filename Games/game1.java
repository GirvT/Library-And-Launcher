import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.Applet;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class game1 
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
      setSize(600, 400);
      g.setFont(new Font("Helvetica", Font.BOLD, 24)); 
      g.setColor(Color.red);  
      g.drawRect(540,340,50,50);
      setBackground(Color.white);
      Graphics2D g2 = (Graphics2D)g;
      g.setColor(Color.black);
      g2.fill(rect);
      g.drawString("Move to the red square.", 175,100);
      if (rect.x==540 && rect.y==340)
         {
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.BLACK);
         g.drawString("You Win!", 240,100);
         boolean game_condition = false;
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
     
     
