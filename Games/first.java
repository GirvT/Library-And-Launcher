import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

   public class first extends JPanel implements ActionListener, KeyListener{
   
      double x = 0, y = 0;
      
      public first(){
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
      }
      
      public void paintComponent(Graphics g){
         super.paintComponent(g);
         g.setFont(new Font("Helvetica", Font.BOLD, 24));
         g.setColor(Color.red);  
         g.drawRect(540,340,50,50);
         g.setColor(Color.black);;
         Graphics2D g2 = (Graphics2D) g;
         g.setColor(Color.black);
         g2.fill(new Rectangle2D.Double(x, y, 50, 50));
         if (x == 540 && y == 340) 
            {
   	      g.setColor(Color.WHITE);
   	      g.fillRect(0, 0, getWidth(), getHeight());
   	      g.setColor(Color.BLACK);
   	      g.drawString("You Win!", 240,100);
   	      g.drawString("Press R to play again", 180,150);
            }  
      }
      
      public void actionPerformed(ActionEvent e){
         repaint();
      }        
      
      public void up(){
         y -= 10;
      }
      
      public void down(){
         y += 10;
      }
      
      public void left(){
         x -= 10;
      }
      
      public void right(){
         x += 10;
      }
      
      
      public void keyPressed(KeyEvent e){
         int code = e.getKeyCode();
         if (code == KeyEvent.VK_UP)
            up();
         if (code == KeyEvent.VK_DOWN)
            down();
         if (code == KeyEvent.VK_LEFT)
            left();
         if (code == KeyEvent.VK_RIGHT)
            right();  
         if (code == KeyEvent.VK_R)
            {
            x = 0;
            y = 0;
         }
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){}
      
   }