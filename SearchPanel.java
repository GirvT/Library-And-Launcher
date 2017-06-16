//Author: Manish Suresh 
//Date : 08/06/17

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;

/**
@author Manish Suresh
SearchPanel class is the GUI equlivant to Search class.
*/  
 
public class SearchPanel extends JPanel
{
   //Instaniate required objects
   GamesLoader gl = new GamesLoader();
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   Search si = new Search();
   Add ad = new Add();  
   Smoke sMain = new Smoke();

   //Panel Elements
   JTextArea display = new JTextArea();
   JTextArea display2 = new JTextArea();
   JTextArea display3 = new JTextArea();
   JTextField userInput = new JTextField();
   
   //Variables
   final int MAX = 10;//Set MAX number of records
   int x = 0;
   static String fileName = "records.txt";//fileName = "records.txt"   
   static String logName = "log.txt";//fileName = "records.txt"  
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   String variables[] = {"Name","Filename","Method Name","Date Created","Rating","Author"};
   String search_input, input;
   
   //Dropdown Menu
   JComboBox options = new JComboBox(variables);
   
   /**
   "SearchPanel" does the "search" method while retaning the name of the class
   @param JFrame The main JFrame that instantiates "search"
   @param access The access level of the user
   */
   public SearchPanel(final JFrame Frame, final String access)
   {
      search(Frame, access);
   }
   
   /**
   "search" creates a JPanel that has the functionallity to find data from records
   @param JFrame The main JFrame that instantiates "search"
   @param access The access level of the user
   */
   public void search(final JFrame frame, final String Access)
   {
      frame.setResizable(false);
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
         
         JButton Search = new JButton("Search");
         JButton Launch = new JButton("Launch");
         JButton Home = new JButton("Home");
         
         display2.setText("What would you like to search?");
         display2.setEditable(false);
         display2.setOpaque(false);
         display2.setForeground(new Color(234, 234, 225));

         display3.setText("     |Name|" + "\t|FileName|" + "\t|Method Name|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
         display3.setEditable(false);
         display3.setOpaque(false);
                
         display3.setForeground(new Color(234, 234, 225));
         
         Search.setFocusPainted(false);
         Search.setContentAreaFilled(false);
         Search.setForeground(new Color(234, 234, 225));
         
         Home.setFocusPainted(false);
         Home.setContentAreaFilled(false);
         Home.setForeground(new Color(234, 234, 225));
         
         Launch.setFocusPainted(false);
         Launch.setContentAreaFilled(false);
         Launch.setForeground(new Color(234, 234, 225));
         
         options.setSelectedIndex(0);
         
         Search.setBounds(300,300,100,30);
         Home.setBounds(100,320,100,30);
         display2.setBounds(265,165,180,40);
         userInput.setBounds(300,250,100,30);
         display3.setBounds(70,60,560,100);
         Launch.setBounds(500,320,100,30);
         options.setBounds(275,200,150,25);
         
         JScrollPane scrollPane = new JScrollPane(display3,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scrollPane.setBounds(70, 60, 560, 100);
         scrollPane.getViewport().setOpaque(false);
         scrollPane.setOpaque(false);
         
         panel.add(display2);
         panel.add(Search);
         panel.add(display3);
         panel.add(userInput);
         panel.add(Home);
         panel.add(Launch);
         panel.add(options);
         panel.add(scrollPane);
         add(panel);
                              
         rows = rd.readFile(fileName, 10);
         info = re.getRecords(rows);
         
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
                                
      Search.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  display.setText("");                  
            search_input = userInput.getText();    
            display3.setText("     |Name|" + "\t|FileName|" + "\t|Method Name|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
            display3.append(si.searchGame(fileName, info, x, search_input));   
         }
      });
      
      Home.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            frame.dispose();
            sMain.mainFrame(Access);
         }
      });
      
      display3.addMouseListener(new MouseAdapter() 
      {
         @Override
         public void mouseClicked(MouseEvent e) 
         {
            if (e.getButton() != MouseEvent.BUTTON1) 
            {
               return;
            }
            if (e.getClickCount() != 1) 
            {
               return;
            }
            int offset = display3.viewToModel(e.getPoint());
            try 
            {
               int rowStart = Utilities.getRowStart(display3, offset);
               int rowEnd = Utilities.getRowEnd(display3, offset);
               String selectedLine = display3.getText().substring(rowStart, rowEnd);
               input = selectedLine.trim();
               System.out.println(input);

            }
            catch (BadLocationException e1) 
            {
               e1.printStackTrace();
            }
         }
      });
      
      Launch.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent a)
         {
            String input2 = input.replaceAll("\\s","");
            rows = rd.readFile(fileName, 10);
            info = re.getRecords(rows);
            gl.load(input2, info);            
         }
      });// end Launch ActionListener
               
         panel.setPreferredSize(new Dimension(700, 375));
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