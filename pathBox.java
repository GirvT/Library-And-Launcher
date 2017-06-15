
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

   public class pathBox extends JPanel implements ActionListener, KeyListener{
      Timer t = new Timer(30,this);
      double x = 0, y = 0;
      boolean cond = true;
      Add ad = new Add();
      static String logName = "log.txt";//fileName = "records.txt"
      ClassLoaderTest cl = new ClassLoaderTest();
      
      public pathBox(){
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
         {
            if (x != 540 || y != 340)
               up();
         }
         if (code == KeyEvent.VK_DOWN )
            {
            if (x != 540 || y != 340)
               down();
         }
         if (code == KeyEvent.VK_LEFT )
            {
            if (x != 540 || y != 340)
               left();
         }
         if (code == KeyEvent.VK_RIGHT )
            {
            if (x != 540 || y != 340)
               right();
              
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
      
      /**
      "startGame1" draws the frame and initates the game elements in the frame
      */
      public void startGame1()
      {
         JFrame Frame = new JFrame();
         pathBox s = new pathBox();
         Frame.setSize(800,600);    
         Frame.getContentPane().add(s);
         Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         Frame.setLocationRelativeTo(null);
         Frame.setVisible(true);
      }
      
   }