//Author: Keith Chow
//Date : 05/03/17

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.Applet;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
@author Keith Chow
"guessing" is a game where the player guesses from 1-6 a number, if that number matches a number generate in the
same range then they get a life otherwise they lose a life at zero lives the player loses the game
*/
   public class guessing extends JPanel implements ActionListener, KeyListener{
   
      //Variables and objects in use
      Timer t = new Timer(30,this);
      int lives = 5;
      
      /**
      "guessing" initates game functions without a frame
      */
      public guessing(){
         t.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
      }
      
      /**
      "paintComponent" draws graphics elements of the game
      */
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         setSize(600, 400);
         g.setFont(new Font("Helvetica", Font.BOLD, 24)); 
         setBackground(Color.white);
         Graphics2D g2 = (Graphics2D)g;
         g.setColor(Color.black);
         //Instruction
         g.drawString("Choose a number between 1-6", 130,120);
         g.drawString("Wrong guess = lose a life", 160,160);
         g.drawString("Right guess = gain a life", 175,190);
         g.drawString("Lives remaining = " + lives, 350,40);
         //Loss condition
         if (lives<=0)
         {
            g.clearRect(0, 0, getWidth(), getHeight()); 
            g.setColor(Color.black);
            g.drawString("You Lost!", 265,40);
            g.drawString("Press Q to exit the game, press R to restart", 60,75);
         }  
      }
      
      //Generate random number function 
      public void rando()
      {
         int randArray[]={1,2,3,4,5,6};
         Random rand = new Random();
         int  num = rand.nextInt(6);
         int n = randArray[num];
         if (lives >= 0)
            {
            repaint();  
            }
      }
      
      public void actionPerformed(ActionEvent e)
      {                  
         repaint();  
      }
              
      //On keypress generate a number and check if the number pressed is the same as the one generated, if yes gain a life
      // if no lose a life.
      public void keyPressed(KeyEvent e)
      {
         Random rand = new Random();
         int  num = rand.nextInt(6);
         int randArray[]={1,2,3,4,5,6};
         int n = randArray[num];
         int code = e.getKeyCode();
         
         if (code == KeyEvent.VK_1 || code == KeyEvent.VK_NUMPAD1)
         {
            if (n == 1)
            {
               lives++;
               rando();
            } 
            else
            {
               lives--;  
               rando();
            }
         }
         
         if (code == KeyEvent.VK_2 || code == KeyEvent.VK_NUMPAD2)
         {
         if (n == 2)
               {
               lives++;
               rando();
               } 
            else
               {
               lives--;  
               rando();
               }
         }
         
         if (code == KeyEvent.VK_3 || code == KeyEvent.VK_NUMPAD3)
         {
            if (n == 3)
            {
               lives++;
               rando();
            } 
            else
            {
               lives--;  
               rando();
            }
         }
         
         if (code == KeyEvent.VK_4 || code == KeyEvent.VK_NUMPAD4)
         {
            if (n == 4)
               {
               lives++;
               rando();
               } 
            else
            {
               lives--;  
               rando();
            }
         }
         
         if (code == KeyEvent.VK_5 || code == KeyEvent.VK_NUMPAD5)
         {
            if (n == 5)
               {
               lives++;
               rando();
               } 
            else
            {
               lives--;  
               rando();
            }
         }
         
         if (code == KeyEvent.VK_6 || code == KeyEvent.VK_NUMPAD6)
         {
            if (n == 6)
               {
               lives++;
               rando();
               } 
            else
            {
               lives--;  
               rando();
            }
         }
               
         if (code == KeyEvent.VK_R)
         {
            lives = 5;
            repaint();
         }
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){}
      
      /**
      "startGame4" draws the frame and initates the game elements in the frame
      */
      public void startGame4()
      {
         JFrame Frame = new JFrame();
         guessing s = new guessing();
         Frame.setSize(800,600);    
         Frame.getContentPane().add(s);
         Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         Frame.setLocationRelativeTo(null);
         Frame.setVisible(true);
      }
      
   }