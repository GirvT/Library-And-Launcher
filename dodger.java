//Author: Manish Suresh 
//Date : 08/06/17

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
@author Manish Suresh
dodger class is a game where you attempt to dodge moving obsticales while trying to reach the goal.
*/ 

public class dodger extends JPanel implements ActionListener, KeyListener
{
   
      //Variables and objects in use
      Timer t = new Timer(30,this);
      double x = 0, y = 0;
      int a = 100, b = 50;
      int c = 100, d = 100;
      boolean alive = true;
      
      /**
      "dodger" initates game functions without a frame
      */
      public dodger(){
         t.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
      }
      
      /**
      "paintComponent" draws graphics elements of the game
      @param g is the panel that contains the drawn graphics
      */
      public void paintComponent(Graphics g){
         super.paintComponent(g);
         g.setFont(new Font("Helvetica", Font.BOLD, 24));
         g.setColor(Color.red);  
         g.drawRect(50,500,50,50);
         g.setColor(Color.green);
         g.fillRect(0,150,500,300);
         g.setColor(Color.blue);
         g.fillRect(a,b,50,50);
         g.setColor(Color.magenta);
         g.fillRect(c,d,50,50);
         g.setColor(Color.black);
         
         //Instructions
         g.drawString("Using the arrow keys move the black", 20,220);
         g.drawString("square to the red square to win", 20,250);
         g.drawString("the game. Avoid touching the other ", 20,280);
         g.drawString("solid boxes to prevent losing.", 20,310);
         
         Graphics2D g2 = (Graphics2D) g;
         g.setColor(Color.black);
         g2.fill(new Rectangle2D.Double(x, y, 50, 50));
         
         // Win/Loss conditions
         if (x == 50 && y == 500) 
         {
   	      g.setColor(Color.WHITE);
   	      g.fillRect(0, 0, getWidth(), getHeight());
   	      g.setColor(Color.BLACK);
   	      g.drawString("You Win!", 350,100);
   	      g.drawString("Press R to play again", 250,150);        
            alive = false;
         }
         else if (x >a-50 && y>b-50 && y<b+50 && x<a+50||x>c-50 && y>d-50 && y<d+50 && x<c+50)
         {
   	      g.setColor(Color.WHITE);
   	      g.fillRect(0, 0, getWidth(), getHeight());
   	      g.setColor(Color.BLACK);
   	      g.drawString("You Lose! Press R to restart", 140,100);
            alive = false;
         }
         else if (x < 500 && y+50 > 150 && y+50<500) 
         {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.drawString("You Lose! Press R to restart", 200,100); 
            alive = false;
         }  
      }
      
      
      public void actionPerformed(ActionEvent e)
      {
         if (a >= 800 && alive) 
         {
            repaint();
            a = 0;
         } 
         else if (alive) 
         {
            repaint();
            a += 10;
         }
         if (c<=0 && alive)
         {
            repaint();
            c = 800;
         }
         else if (alive)
         {
            repaint();
            c -=6;   
         }
         if (y>=250)
         {
            b = 450;
            d = 510;
            repaint();  
         }
      }        
      
      public void up()
      {
         y -= 10;
      }
      
      public void down()
      {
         y += 10;
      }
      
      public void left()
      {
         x -= 10;
      }
      
      public void right()
      {
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
            x = 0;
            y = 0;
         } 
         
         
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){}
      
      /**
      "startGame2" draws the frame and initates the game elements in the frame
      */
      public void startGame2()
      {
         JFrame Frame = new JFrame();
         dodger s = new dodger();
         Frame.setSize(800,600);    
         Frame.getContentPane().add(s);
         Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         Frame.setLocationRelativeTo(null);
         Frame.setVisible(true);
      }
      
}