//Author: Manish Suresh 
//Date : 08/06/17

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;

/**
@author Manish Suresh
DeletePanel class is the GUI equlivant to Delete class.
*/ 

public class DeletePanel extends JPanel
{
   //Instaniate required objects
   GamesLoader gl = new GamesLoader();
   ReadData rd = new ReadData();
   Records re = new Records();
   Delete di = new Delete();
   Smoke sMain = new Smoke();
   
   //Panel elements
   JTextField display = new JTextField();
   JTextField display2 = new JTextField();
   JTextField userInput = new JTextField();
   
   //Variables
   static String fileName = "records.txt";//fileName = "records.txt"
   static String logName = "log.txt";//fileName = "records.txt"   
   String search_input = new String();
   final int MAX = 10;//Set MAX number of records
   int x = 0;
   int xSize1 = 300,ySize1 = 500;
   String input, input2;
   String rows[] = new String[MAX];
   String info[][] = new String[MAX][6];
   String variables[] = {"Name","Filename","Method Name","Date Created","Rating","Author"};
   JComboBox options = new JComboBox(variables);

   /**
   "DeletePanel" does the "delete" method while retaning the name of the class
   @param JFrame The main JFrame that instantiates "delete"
   @param access The access level of the user
   */
   public DeletePanel (final JFrame Frame, final String access)
   {
      delete(Frame, access);
   }
   
   /**
   "delete" creates a JPanel that has the functionallity to delete data from records
   @param JFrame The main JFrame that instantiates "delete"
   @param access The access level of the user
   */
   public void delete(final JFrame frame,final String Access)
   {
      final Image image = requestImage();
      JPanel panel = new JPanel() 
      {
         @Override
         protected void paintComponent(Graphics g)
         {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
         }
      };
          
      panel.setLayout(null);   
      
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
      
         //Buttons
         JButton Delete = new JButton("Delete");
         JButton Home = new JButton("Home");
         
         //Labels
         display2.setText("What would you like to delete by?");
         display2.setEditable(false);
         display2.setOpaque(false);
         display2.setForeground(new Color(234, 234, 225));
         display2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
         Delete.setFocusPainted(false);
         Delete.setContentAreaFilled(false);
         Delete.setForeground(new Color(234, 234, 225));
         
         Home.setFocusPainted(false);
         Home.setContentAreaFilled(false);
         Home.setForeground(new Color(234, 234, 225));
         
         options.setSelectedIndex(0);

         //Set bounds of labels and input boxes
         Delete.setBounds(475,120,100,30);
         Home.setBounds(75,120,100,30);
         display2.setBounds(245,25,180,40);
         userInput.setBounds(275,100,100,30);
         options.setBounds(250,60,150,25);         
         
         //Add input boxes and labels to main panel
         panel.add(display2);
         panel.add(Delete);
         panel.add(userInput);
         panel.add(Home);
         panel.add(options);
         add(panel);
         
         
         options.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
         {  
            String text = (String)options.getSelectedItem();
            if (text.equals(variables[0]))
               x=0;
            else if (text.equals(variables[1]))
               x=1;
            else if (text.equals(variables[2]))
               x=2;
            else if (text.equals(variables[3]))
               x=3;
            else if (text.equals(variables[4]))
               x=4;
            else if (text.equals(variables[5]))
               x=5;
         }
      });
         
      //Delete button function        
      Delete.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            display.setText("");                  
            search_input = userInput.getText();   
            di.deleteGame(fileName, info, x, search_input);
            JOptionPane.showMessageDialog(null, " Successfully Deleted.");
            frame.dispose();
            sMain.mainFrame(Access);
    
         }
      });
      
      //Home button
      Home.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            frame.dispose();
            sMain.mainFrame(Access);         
         }
      });
               
      panel.setPreferredSize(new Dimension(650, 200));
   }
   
   //Background
   private Image requestImage()
   {
      Image image = null;
      try 
      {
         image = ImageIO.read(new File("aa.png"));
      } catch (IOException e) 
      {
         e.printStackTrace();
      }
      return image;
   }
}