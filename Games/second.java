import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

   public class second extends JPanel implements ActionListener, KeyListener{
   
      Timer t = new Timer(30,this);
      double x = 0, y = 0;
      int a = 100, b = 100;
      
      public second(){
         t.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
      }
      
      public void paintComponent(Graphics g){
         super.paintComponent(g);
         g.setFont(new Font("Helvetica", Font.BOLD, 24));
         g.setColor(Color.red);  
         g.drawRect(540,340,50,50);
         g.setColor(Color.green);
         g.drawRect(0,150,500,300);
         g.setColor(Color.blue);
         g.drawRect(a,b,50,50);
         g.drawString("Move the black square to the red square.", 175,100);
         g.drawString("Don't try crossing me >:(", 150,250);
         Graphics2D g2 = (Graphics2D) g;
         g.setColor(Color.black);
         g2.fill(new Rectangle2D.Double(x, y, 50, 50));
         if (x == 540 && y == 340){
   	      g.setColor(Color.WHITE);
   	      g.fillRect(0, 0, getWidth(), getHeight());
   	      g.setColor(Color.BLACK);
   	      g.drawString("You Win!", 240,100);
   	      g.drawString("Press R to play again", 180,150);
         }else if (x >a-50 && y>b-50 && y<b+50 && x<a+50){
   	      g.setColor(Color.WHITE);
   	      g.fillRect(0, 0, getWidth(), getHeight());
   	      g.setColor(Color.BLACK);
   	      g.drawString("You Lose! Press R to restart", 140,100);
         }else if (x < 501 && y+50 > 150 ){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString("You Lose! Press R to restart", 140,100); 
         }  
      }
      
      public void actionPerformed(ActionEvent e){
         if (a >= 800) {
            repaint();
            a = 0;
         } else {
            repaint();
            a += 8;
         }
      }
      
      public void up(){
         y -= 5;
      }
      
      public void down(){
         y += 5;
      }
      
      public void left(){
         x -= 5;
      }
      
      public void right(){
         x += 5;
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
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){}
      
   }