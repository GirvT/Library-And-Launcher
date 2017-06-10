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
AddPanel class is the GUI equlivant to Add class.
*/ 
 
public class AddPanel extends JPanel
{
   //Instinatate required objects
   ReadData rd = new ReadData();
   Records re = new Records();
   KeyInput ki = new KeyInput();
   Add ad = new Add();
   Search si = new Search();
   Smoke sMain = new Smoke();
   
   //Create a text field and label for each part of data input
   JTextField display = new JTextField();
   JTextField display2 = new JTextField();
   JTextField display3 = new JTextField();
   JTextField display4 = new JTextField();
   JTextField display5 = new JTextField();
   JTextField display6 = new JTextField();
   JTextField add1 = new JTextField();
   JTextField add2 = new JTextField();
   JTextField add3 = new JTextField();
   JTextField add4 = new JTextField();
   JTextField add5 = new JTextField();
   JTextField add6 = new JTextField();

   static String fileName = "records.txt";
   static String logName = "log.txt";   

   final int MAX = 10;//Set MAX number of records
   int xSize1 = 300,ySize1 = 500;

   String input, input2;
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   
   /**
   "AddPanel" does the add() method while retaning the name of the class
   @param JFrame The main JFrame that instantiates "add"
   @param access The access level of the user
   */
   public AddPanel (final JFrame Frame, final String access)
   {
      add(Frame, access);
   }
   
   /**
   "add" creates a JPanel that has the functionallity to add data to records
   @param JFrame The main JFrame that instantiates "add"
   @param access The access level of the user
   */
   public void add(final JFrame frame, final String Access)
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
      
      //Buttons
      JButton addEntry = new JButton("Add Entry");
      JButton Home = new JButton("Home");
        
      //Input Boxes  
      display.setText("Name");
      display.setEditable(false);
      display.setOpaque(false);
      display.setForeground(new Color(234, 234, 225));
      display.setHorizontalAlignment(SwingConstants.CENTER);
      display.setBorder(null);

      display2.setText("Filename");
      display2.setEditable(false);
      display2.setOpaque(false);
      display2.setForeground(new Color(234, 234, 225));
      display2.setHorizontalAlignment(SwingConstants.CENTER);     
      display2.setBorder(null);
      
      display3.setText("Method Name");
      display3.setEditable(false);
      display3.setOpaque(false);
      display3.setForeground(new Color(234, 234, 225));
      display3.setHorizontalAlignment(SwingConstants.CENTER);
      display3.setBorder(null);

      display4.setText("Date Created");
      display4.setEditable(false);
      display4.setOpaque(false);
      display4.setForeground(new Color(234, 234, 225));
      display4.setHorizontalAlignment(SwingConstants.CENTER);
      display4.setBorder(null);
      
      display5.setText("Rating");
      display5.setEditable(false);
      display5.setOpaque(false);
      display5.setForeground(new Color(234, 234, 225));
      display5.setHorizontalAlignment(SwingConstants.CENTER);
      display5.setBorder(null);

      display6.setText("Created By");
      display6.setEditable(false);
      display6.setOpaque(false);
      display6.setForeground(new Color(234, 234, 225));
      display6.setHorizontalAlignment(SwingConstants.CENTER);
      display6.setBorder(null);
        
      addEntry.setFocusPainted(false);
      addEntry.setContentAreaFilled(false);
      addEntry.setForeground(new Color(234, 234, 225));

      Home.setFocusPainted(false);
      Home.setContentAreaFilled(false);
      Home.setForeground(new Color(234, 234, 225));
            
      //Bounds of input boxes and labels   
      add1.setBounds(30,150,100,30);
      add2.setBounds(140,150,100,30);
      add3.setBounds(250,150,100,30);
      add4.setBounds(360,150,100,30);
      add5.setBounds(470,150,100,30);
      add6.setBounds(580,150,100,30);
      addEntry.setBounds(500,320,100,30);
      Home.setBounds(100,320,100,30);
      display.setBounds(30,110,100,30);
      display2.setBounds(140,110,100,30);
      display3.setBounds(250,110,100,30);
      display4.setBounds(360,110,100,30);
      display5.setBounds(470,110,100,30);
      display6.setBounds(580,110,100,30);
         
      //Add input boxes and labels to the main panel
      panel.add(display);
      panel.add(addEntry);
      panel.add(display2);
      panel.add(display3);
      panel.add(display4);
      panel.add(display5);
      panel.add(display6);
      panel.add(add1);
      panel.add(add2);
      panel.add(add3);
      panel.add(add4);
      panel.add(add5);
      panel.add(add6);
      panel.add(Home);  
      add(panel);
      
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
      
      //if "addEntry" button is clicked call the addGame method                   
      addEntry.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {                  
            //If any boxes are empty, fail to add to records
            if(
                    add1.getText().trim().length() > 0
                &&  add2.getText().trim().length() > 0
                &&  add3.getText().trim().length() > 0
                &&  add4.getText().trim().length() > 0
                &&  add5.getText().trim().length() > 0
                &&  add6.getText().trim().length() > 0
              )
            {
               ad.addGame(fileName, ki.entries(add1, add2, add3, add4, add5, add6));
               JOptionPane.showMessageDialog(null, " Successfully Added.");
               frame.dispose();
               sMain.mainFrame(Access);
            } 
         }
      });
      
      //if "home" button is clicked go back to main frame
      Home.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            frame.dispose();
            sMain.mainFrame(Access);         
         }
      });           
     
      panel.setPreferredSize(new Dimension(700, 375));
   }
   
   //Set Background
   private Image requestImage()
   {
      Image image = null;
      try 
      {
         image = ImageIO.read(new File("aa.png"));
      } 
      catch (IOException e) 
      {
         e.printStackTrace();
      }
      return image;
   }
}