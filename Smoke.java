import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Smoke{
   String nameArray[] = new String[6];
   static String fileName = "records.txt";//fileName = "records.txt"
   final int MAX = 10;//Set MAX number of records
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
<<<<<<< HEAD
   int xSize = 700,ySize = 500;
   String input = "";
=======
   int xSize1 = 300,ySize1 = 500;
   int xSize = 700,ySize = 500; 
   String input;
>>>>>>> origin/master
   JTextField field = new JTextField();
   JTextField passLabel = new JTextField("Enter your password");
   JPasswordField passField = new JPasswordField();
   
   
   public Smoke()
   {
      frame();
   }
   
   public void frame()
   {
      final JFrame window = new JFrame("Smoke");
      window.setSize(xSize1,ySize1);
      window.setResizable(true);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocationRelativeTo(null);
        
      JPanel panel = new JPanel();
      panel.setLayout(null);
      window.add(panel);
            
      JButton Login = new JButton("Login");
      JButton Quit = new JButton("Quit");
      Login.setBackground(new Color(59, 89, 182));
      Login.setForeground(Color.WHITE);
      Login.setFocusPainted(false);
      Login.setFont(new Font("Tahoma", Font.BOLD, 12));
       
      Quit.setBackground(new Color(255, 10, 10));
      Quit.setForeground(Color.WHITE);
      Quit.setFocusPainted(false);
      Quit.setFont(new Font("Tahoma", Font.BOLD, 12));
      
      Login.setBounds(85,300,120,40);
      Quit.setBounds(85,350,120,40);
      panel.add(Login);
      panel.add(Quit);
      
      passField.setEditable(true);      
<<<<<<< HEAD
      passField.setBounds(295,350,100,30);
      panel.add(passField);     
     
                 input = passField.getText();

=======
      passField.setBounds(70,150,150,30);
      panel.add(passField);
      
      passLabel.setOpaque(false);
      passLabel.setBounds(70,120,150,30);
      panel.add(passLabel);
      passLabel.setEditable(false); 
      window.setVisible(true);
      
>>>>>>> origin/master
     
      Login.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            input = passField.getText();
            if (input.equals("password"))
            {
                  JOptionPane.showMessageDialog(null, "Login Sucessful!");
                  frame2();
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Incorrect password, please try again.");
            }
         }      
      });

      Quit.addActionListener(new ActionListener()
      {      
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      });
   }// end frame
   
   private void passFieldKeyPressed(KeyEvent evt)
   {

      if(evt.getKeyCode() == KeyEvent.VK_ENTER)
      {
         System.out.println(input);
            if (input.equals("password"))
            {
                  JOptionPane.showMessageDialog(null, "Login Sucessful!");
                  frame2();
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Incorrect password, please try again.");
            }
      }  
   }
   
   
   public void frame2()
   {
      final JFrame window = new JFrame("Smoke");
      window.setVisible(true);
      window.setSize(xSize,ySize);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocationRelativeTo(null);
      
      final JPanel panel = new JPanel();
      panel.setLayout(null);
      window.add(panel);
            
      JButton View = new JButton("View");
      JButton Quit = new JButton("Quit");
      JButton Launch = new JButton("Launch");
      JButton Sort = new JButton("Sort");
      View.setBounds(220,430,100,30);
      Quit.setBounds(520,430,100,30);
      Launch.setBounds(370,430,100,30);
      Sort.setBounds(70,430,100,30);
      panel.add(View);
      panel.add(Quit);
      panel.add(Launch);
      panel.add(Sort);
      
      JTextArea display = new JTextArea();
      display.setEditable(false);
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < info.length-5; i++)
      {
         for(int j = 0; j < info[0].length; j++)
         {
            sb.append(info[i][j] + "\t");
         }
         sb.append("\n");
      }
      display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
      display.append(sb.toString());
      JScrollPane scrollPane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBounds(80, 120, 540, 160);
      panel.add(scrollPane);       
      
      field.setEditable(true);      
      field.setBounds(295,350,100,30);
      panel.add(field);
      
            
      

      
      Sort.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //window.dispose();// close the current fram
            sortFrame();// open the frame used for sorting
         }
      });// end Sort ActionListener
      
      Launch.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent a)
         {
            input = field.getText();
            if (input.equals("game1"))
            {
               game1();
            }
            else if (input.equals("game2"))
            {
               game2();
            }
            else if (input.equals("game3"))
            {
               game3();
            }
            else if (input.equals("game4"))
            {
               //game4();
            }
            
         }
      });// end Launch ActionListener
           
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
      window.setSize(xSize,ySize);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocationRelativeTo(null);
            
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
   }// end frame sortFrame
   
   public void game1()
   {
      JFrame f = new JFrame("");
      first s = new first();
      f.setSize(800,600);    
      f.add(s);
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }
      
   public void game2()
   {
      JFrame f = new JFrame("");
      second s = new second();
      f.setSize(800,600);    
      f.add(s);
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }
   
    public void game3()
    {
      JFrame f = new JFrame("");
      third s = new third();
      f.setSize(800,600);    
      f.add(s);
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }
   
   private Image requestImage() {
        Image image = null;

        try {
            image = ImageIO.read(new File("aa.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
   
   public static void main(String[] args)
   {
      new Smoke();
   }
          
}// end program

