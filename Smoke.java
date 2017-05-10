import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Using AWT event classes and listener interfaces

public class Smoke
{
   String nameArray[] = new String[6];
   static String fileName = "records.txt";//fileName = "records.txt"
   final int MAX = 10;//Set MAX number of records
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   
   public Smoke()
   {
      frame();
   }
   
   public void frame()
   {
      final JFrame window = new JFrame("Smoke");
      window.setVisible(true);
      window.setSize(700,500);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
      panel.setLayout(null);
      window.add(panel);
      
      JButton Start = new JButton("Start");
      JButton Quit = new JButton("Quit");
      Start.setBounds(100,400,120,40);
      Quit.setBounds(400,400,120,40);
      panel.add(Start);
      panel.add(Quit);
      
      Start.addActionListener(new ActionListener()
      {      
         public void actionPerformed(ActionEvent e)
         {
            window.dispose();
            frame2();
         }
      });// end Start actionListener
      
      Quit.addActionListener(new ActionListener()
      {      
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      });
   }// end frame
   
   public void frame2()
   {
      final JFrame window = new JFrame("Smoke");
      window.setVisible(true);
      window.setSize(700,500);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      final JPanel panel = new JPanel();
      panel.setLayout(null);
      window.add(panel);
            
      JButton View = new JButton("View");
      JButton Quit = new JButton("Quit");
      JButton Launch = new JButton("Launch");
      JButton Sort = new JButton("Sort");
      View.setBounds(200,430,100,30);
      Quit.setBounds(550,430,100,30);
      Launch.setBounds(400,430,100,30);
      Sort.setBounds(50,430,100,30);
      panel.add(View);
      panel.add(Quit);
      panel.add(Launch);
      panel.add(Sort);
      
      JTextArea field = new JTextArea();
      field.setEditable(false);
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < info.length-3; i++)
      {
         for(int j = 0; j < info[0].length; j++)
         {
            sb.append(info[i][j] + "\t");
         }
         sb.append("\n");
      }
      field.append("Name" + "\tYear\n");
      field.append(sb.toString());
      JScrollPane scrollPane = new JScrollPane(field,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBounds(160,100, 300, 150);
      panel.add(scrollPane);       
      
      
      Sort.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            window.dispose();
            sortFrame();
         }
      });// end Sort ActionListener
           
       Quit.addActionListener(new ActionListener()
       {      
          public void actionPerformed(ActionEvent e)
          {
             System.exit(0);
          }
      });// end Quit ActionListener
   }// end frame2
   
   public void sortFrame()
   {
      final JFrame window = new JFrame("Smoke");
      window.setVisible(true);
      window.setSize(700,500);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
      JPanel panel = new JPanel();
      panel.setLayout(null);
      window.add(panel);
           
      JButton Name = new JButton("By Name");
      Name.setBounds(300,430,100,30);
      panel.add(Name);
      
      Name.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            window.dispose();
            frame2();
         }
      });// end Name ActionListener
   }// end frame 3
      
   public static void main(String[] args)
   {
      new Smoke();
   }
          
}// end program

