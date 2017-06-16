//Author: Luciano Wong 
//Date : 08/06/17

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
@author Luciano Wong
rebound class is a game where you attempt to keep 3 squares from getting to the red hollow square,
you can do that by moving into the squares to reset their position. If you manage to defend from 5 squares
then you win.
*/ 


public class rebound extends JPanel implements ActionListener, KeyListener
{
   //Variables and objects in use
   Timer t = new Timer(30,this);
   double x = 500, y = 450;
   int a = 700, b = 50;
   int c = 310, d = 100;
   int f = 500, h = 0;
   int i = 3;
   boolean alive = false;
   
   /**
      "rebound" initates game functions without a frame
   */
   public rebound()
   {
      t.start();
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
   }
   
   /**
   "paintComponent" draws graphics elements of the game
   @param g is the panel that contains the drawn graphics
   */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.setFont(new Font("Helvetica", Font.BOLD, 24));
      g.setColor(Color.pink);  
      g.fillRect(0,0,1000,1000);
      g.setColor(Color.red);  
      g.drawRect(500,500,50,50);
      g.setColor(Color.yellow);
      g.fillRect(f,h,50,50);
      g.setColor(Color.blue);
      g.fillRect(a,b,50,50);
      g.setColor(Color.magenta);
      g.fillRect(c,d,50,50);
      g.setColor(Color.black);
      g.drawString("Move the black square to fend off.", 20,190);
      g.drawString("the moving squares, if they reach", 20,220);
      g.drawString("the red square you lose but if you", 20,250);
      g.drawString("fend off enough squares, you win", 20,280);
      g.drawString("*Using arrow keys to move, hit R", 20,310);
      g.drawString("to start", 20,340);
      Graphics2D g2 = (Graphics2D) g;
      g.setColor(Color.black);
      g2.fill(new Rectangle2D.Double(x, y, 50, 50));
      
      if (x >a-50 && y>b-50 && y<b+50 && x<a+50||x>c-50 && y>d-50 && y<d+50 && x<c+50||x>f-50 && y>h-50 && y<h+50 && x<f+50)
      {
         i = i-1;
	      g.setColor(Color.WHITE);
	      g.fillRect(0, 0, getWidth(), getHeight());
	      g.setColor(Color.BLACK);    
      }
      else if (500 >a-50 && 500>b-50 && 500<b+50 && 500<a+50||500>c-50 && 500>d-50 && 500<d+50 && 500<c+50||500>f-50 && 500>h-50 && 500<h+50 && 500<f+50)
      {
         alive = false;
         g.drawString("You lose! Press R to restart", 140,100);
      }
      else if (i==0)
      {
         alive = false;
         g.drawString("You Win! Press R to restart", 140,100);
      }
   }
   
   public void actionPerformed(ActionEvent e)
   {
      if (x >a-50 && y>b-50 && y<b+50 && x<a+50 && alive) 
      {
         repaint();
         a = 700;
         b = 50;  
      } 
      else if (alive) 
      {
         repaint();
         a -= 1;
         b += 3;
      }
      if (x>c-50 && y>d-50 && y<d+50 && x<c+50 && alive)
      {
         repaint();
         c = 310;
         d = 100;
      }
      else if (alive)
      {
         repaint();
         c +=1; 
         d +=3;  
      }
      if (x>f-50 && y>h-50 && y<h+50 && x<f+50 && alive)
      {
         h = 0;
         repaint();
      }
      else if (alive)
      {
         repaint();
         h +=2;  
      }   
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
   
   
   public void keyPressed(KeyEvent e)
   {
      int code = e.getKeyCode();
      if (code == KeyEvent.VK_UP)
      {
         if (alive)
         up();
      }
      if (code == KeyEvent.VK_DOWN )
      {
         if (alive)
         down();
      }
      if (code == KeyEvent.VK_LEFT)
      {
         if (alive)
         left();
      }
      if (code == KeyEvent.VK_RIGHT)
      {
         if (alive)
         right();
      } 
      if (code == KeyEvent.VK_R)
      {
         alive = true;
         x = 500;
         y = 450;
         i = 3;
         a = 700; 
         b = 50;
         c = 310;
         d = 100;
         f = 500;
         h = 0;
      }   
   }
   
   public void keyTyped(KeyEvent e){}
   public void keyReleased(KeyEvent e){}
   
   /**
   "startGame5" draws the frame and initates the game elements in the frame
   */
   public void startGame5()
   {
      JFrame Frame = new JFrame();
      rebound s = new rebound();
      Frame.setSize(800,600);    
      Frame.getContentPane().add(s);
      Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      Frame.setLocationRelativeTo(null);
      Frame.setVisible(true);
   }
   
}