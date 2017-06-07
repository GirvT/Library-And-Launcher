import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

   public class first extends JPanel implements ActionListener, KeyListener{
      Timer t = new Timer(30,this);
      double x = 0, y = 0;
      boolean cond = true;
      Add ad = new Add();
      static String logName = "log.txt";//fileName = "records.txt"
      ClassLoaderTest cl = new ClassLoaderTest();
      JFrame test = new JFrame();
      
      public first(JFrame frame){
         t.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
         frame = new JFrame();
         frame = test;
         
      }
      
      public void paintComponent(Graphics g){
         super.paintComponent(g);
         g.setFont(new Font("Helvetica", Font.BOLD, 24));
         g.setColor(Color.red);  
         g.drawRect(540,340,50,50);
         g.setColor(Color.black);
         Graphics2D g2 = (Graphics2D) g;
         g.setColor(Color.black);
         g.drawString("Move the black square to the red using the arrow keys.", 120,100);
         g2.fill(new Rectangle2D.Double(x, y, 50, 50));
         if (x == 540 && y == 340)
         { 
            g.setColor(Color.WHITE);
      	   g.fillRect(0, 0, getWidth(), getHeight());
      	   g.setColor(Color.BLACK);
      	   g.drawString("You Win!", 340,100);
            ad.addGame(logName, "game1 Win");
         }
         
          
      }
      
      public void actionPerformed(ActionEvent e){
         repaint();
      }        
      
      public void up(){
         y -= 10;
         repaint();
      }
      
      public void down(){
         y += 10;
         repaint();
      }
      
      public void left(){
         x -= 10;
         repaint();
      }
      
      public void right(){
         x += 10;
      }
      
      
      public void keyPressed(KeyEvent e){
         int code = e.getKeyCode();
         if (code == KeyEvent.VK_UP)
         {
            if (x != 540 || y != 340 && y >0)
               up();
         }
         if (code == KeyEvent.VK_DOWN )
            {
            if (x != 540 || y != 340 && y <340)
               down();
         }
         if (code == KeyEvent.VK_LEFT )
            {
            if (x != 540 || y != 340 && x >0)
               left();
         }
         if (code == KeyEvent.VK_RIGHT )
            {
            if (x != 540 || y != 340 && x <540)
               right();
               repaint();
         } 
         if (code == KeyEvent.VK_R)
            {
            x = 0;
            y = 0;
            repaint();
         }
         if (code == KeyEvent.VK_Q)
         {
            System.out.println("Selected q");;
            //cl.start("disposeGame1");
            //frame.dispose();
         }
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){}
      
   }