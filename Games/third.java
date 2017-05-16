import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

   public class third extends JPanel implements ActionListener, KeyListener{
   
      Timer t = new Timer(30,this);
      double x = 0, y = 0;
      
      public third(){
         t.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
      }
      
      public void paintComponent(Graphics g){
         super.paintComponent(g);
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
         g.setColor(Color.black);
         g.drawString("Move the black square to the red square.", 175,100);
         g.drawString("Don't try crossing me >:(", 150,250);
         Graphics2D g2 = (Graphics2D) g;
         g.setColor(Color.black);
         g2.fill(new Rectangle2D.Double(x, y, 50, 50));
         if (x==540 && y==340){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString("You Win!", 255,100);
            g.drawString("Press Q to quit, R to restart", 150,150);            
         }
         else if (x<500 && y>200){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
            }
         else if (x>0 && y<200 && x<350){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);            
         }
         else if (x>350 && y>0 && x<540){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);          
         }
         else if (x<0 || y<0){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150); 
         }
         else if (x>540){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 255,100);
             g.drawString("Press Q to quit, R to restart", 150,150);
            
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