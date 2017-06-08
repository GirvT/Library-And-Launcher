import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

   public class maze extends JPanel implements ActionListener, KeyListener{
   
      Timer t = new Timer(30,this);
      double x = 0, y = 0;
      boolean alive = true;
      
      public maze(){
         t.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
      }
      
      public void paintComponent(Graphics g){
         super.paintComponent(g);
         g.setFont(new Font("Helvetica", Font.BOLD, 24));
         g.setColor(Color.red);  
         g.fillRect(540,500,50,50);
         g.setColor(Color.blue);
         g.fillRect(0,250,540,400);
         g.setColor(Color.blue);
         g.fillRect(50,0,300,200);
         g.setColor(Color.blue);
         g.fillRect(540,550,300,200);
         g.setColor(Color.blue);
         g.fillRect(400,50,140,300);
         g.setColor(Color.blue);
         g.fillRect(590,0,200,600);
         g.setColor(Color.black);
         Graphics2D g2 = (Graphics2D) g;
         g.setColor(Color.black);
         g.drawString("Using the arrow keys move the black", 20,280);
         g.drawString("square to the red square to win", 20,310);
         g.drawString("the game. Avoid touching the walls ", 20,340);
         g.drawString("to prevent losing.", 20,370);
         g2.fill(new Rectangle2D.Double(x, y, 50, 50));
         if (x==540 && y==500){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            alive = false;
            g.drawString("You Win!", 360,100);
            g.drawString("Press Q to quit, R to restart", 250,150);            
         }
         else if (x<500 && y>200){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             alive = false;
             g.drawString("You Lose", 360,100);
             g.drawString("Press Q to quit, R to restart", 250,150);
            }
         else if (x>0 && y<200 && x<350){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             alive = false;
             g.drawString("You Lose", 360,100);
             g.drawString("Press Q to quit, R to restart", 250,150);            
         }
         else if (x>350 && y>0 && x<540){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             alive = false;
             g.drawString("You Lose", 360,100);
             g.drawString("Press Q to quit, R to restart", 250,150);          
         }
         else if (x<0 || y<0){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             g.drawString("You Lose", 360,100);
             g.drawString("Press Q to quit, R to restart", 250,150); 
         }
         else if (x>540){
             g.setColor(Color.WHITE);
             g.fillRect(0, 0, getWidth(), getHeight());
             g.setColor(Color.BLACK);
             alive = false;
             g.drawString("You Lose", 360,100);
             g.drawString("Press Q to quit, R to restart", 250,150);
            
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
            {if (alive)
            up();
            }
         if (code == KeyEvent.VK_DOWN)
            {if (alive)
            down();
            }
         if (code == KeyEvent.VK_LEFT)
            {if (alive) 
            left();
            }
         if (code == KeyEvent.VK_RIGHT)
            { if (alive)
            right(); 
            } 
         if (code == KeyEvent.VK_R)
            {
            alive = true;
            x = 0;
            y = 0;
            
         if (code == KeyEvent.VK_Q)
            {
            }
         }
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){}
      
      public void startGame3()
      {
         JFrame Frame = new JFrame();
         maze s = new maze();
         Frame.setSize(800,600);    
         Frame.getContentPane().add(s);
         Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         Frame.setLocationRelativeTo(null);
         Frame.setVisible(true);
      }
      
   }