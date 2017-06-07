import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;
 
public class DeletePanel extends JPanel
{
   GamesLoaderTest gl = new GamesLoaderTest();
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   Delete di = new Delete();
   Smoke2 sMain = new Smoke2();
   
   JTextField display = new JTextField();
   JTextField display2 = new JTextField();
   JTextField display3 = new JTextField();

   
   JTextField userInput = new JTextField();

   static String fileName = "records.txt";//fileName = "records.txt"
   static String logName = "log.txt";//fileName = "records.txt"   
   String search_input = new String();
   final int MAX = 10;//Set MAX number of records
   int xSize1 = 300,ySize1 = 500;

   String input, input2;
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   
   public DeletePanel (final JFrame Frame)
   {
      delete(Frame);
   }
   
   public void delete(final JFrame frame)
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
      
      JButton Delete = new JButton("Delete");
         JButton Launch = new JButton("Launch");
         JButton Home = new JButton("Home");
         
         display2.setText("What would you like to delete?");
         display2.setEditable(false);
         display2.setOpaque(false);
         display2.setForeground(new Color(234, 234, 225));

         display3.setText("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
         display3.setEditable(false);
         display3.setOpaque(false);
         display3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),BorderFactory.createEmptyBorder(10, 10, 10, 10)));         
         display3.setForeground(new Color(234, 234, 225));
         
         Delete.setFocusPainted(false);
         Delete.setContentAreaFilled(false);
         Delete.setForeground(new Color(234, 234, 225));
         
         Home.setFocusPainted(false);
         Home.setContentAreaFilled(false);
         Home.setForeground(new Color(234, 234, 225));
         
         Launch.setFocusPainted(false);
         Launch.setContentAreaFilled(false);
         Launch.setForeground(new Color(234, 234, 225));
            
         Delete.setBounds(300,300,100,30);
         Home.setBounds(100,320,100,30);
         display2.setBounds(270,200,180,40);
         userInput.setBounds(300,250,100,30);
         display3.setBounds(70,60,560,100);
         Launch.setBounds(500,320,100,30);
         
         panel.add(display2);
         panel.add(Delete);
         panel.add(display3);
         panel.add(userInput);
         panel.add(Home);
         panel.add(Launch);
         add(panel);
         
              
      Delete.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            display.setText("");                  
            search_input = userInput.getText();   
            di.deleteGame(fileName, info, 0, search_input);    
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