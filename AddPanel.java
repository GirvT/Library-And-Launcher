import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;
 
public class AddPanel extends JPanel
{
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   KeyInput ki = new KeyInput();
   Add ad = new Add();
   Search si = new Search();
   Smoke2 sMain = new Smoke2();
   
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

   static String fileName = "records.txt";//fileName = "records.txt"
   static String logName = "log.txt";//fileName = "records.txt"   

   final int MAX = 10;//Set MAX number of records
   int xSize1 = 300,ySize1 = 500;

   String input, input2;
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   
   public AddPanel (final JFrame Frame)
   {
      add(Frame);
   }
   
   public void add(final JFrame frame)
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
      
      JButton addEntry = new JButton("Add Entry");
     // JButton Launch = new JButton("Launch");
      JButton Home = new JButton("Home");
        
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
      
      display3.setText("Difficulty");
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
         
     /* Launch.setFocusPainted(false);
      Launch.setContentAreaFilled(false);
      Launch.setForeground(new Color(234, 234, 225));
    */     
      add1.setBounds(30,150,100,30);
      add2.setBounds(140,150,100,30);
      add3.setBounds(250,150,100,30);
      add4.setBounds(360,150,100,30);
      add5.setBounds(470,150,100,30);
      add6.setBounds(580,150,100,30);
      addEntry.setBounds(300,300,100,30);
      Home.setBounds(100,320,100,30);
      display.setBounds(30,110,100,30);
      display2.setBounds(140,110,100,30);
      display3.setBounds(250,110,100,30);
      display4.setBounds(360,110,100,30);
      display5.setBounds(470,110,100,30);
      display6.setBounds(580,110,100,30);
         
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
     // panel.add(Launch);   
      add(panel);
      
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
                        
      addEntry.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {                  
            ad.addGame(fileName, ki.entries(add1, add2, add3, add4, add5, add6));
            frame.dispose();
            sMain.mainFrame();
            JOptionPane.showMessageDialog(null, " Successfully Added.");
         }
      });

      Home.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            frame.dispose();
            sMain.mainFrame();         
         }
      });
      
/*      display2.addMouseListener(new MouseAdapter() 
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
            int offset = display2.viewToModel(e.getPoint());
            try 
            {
               int rowStart = Utilities.getRowStart(display2, offset);
               int rowEnd = Utilities.getRowEnd(display2, offset);
               String selectedLine = display2.getText().substring(rowStart, rowEnd);
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
             if (input2.equals("MazeBoxgame1205/02/17***Keith"))
            {  
               cl.start("game1");
            }
            else if (input2.equals("BoxMazegame2105/02/2017*****Manish"))
            {
               ad.addGame(logName, "game2");
               cl.start("game2");
            }
            else if (input2.equals("Mazegame3305/02/17**Luciano"))
            {
               ad.addGame(logName, "game3");
               cl.start("game3");
            }
            else if (input2.equals("GuessMastergame4505/18/2017*****Keith"))
            {
               ad.addGame(logName, "game4");
               cl.start("game4");
            }
            else 
            {
               JOptionPane.showMessageDialog(null, "Game does not exist, please try a different one.");
            }            
         }
      });// end Launch ActionListener
*/               
         panel.setPreferredSize(new Dimension(700, 375));
   }
   
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