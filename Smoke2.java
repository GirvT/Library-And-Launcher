import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;

public class Smoke2 
{
   private JFrame frame;
   private JFrame frame2;
   String nameArray[] = new String[6];
   static String fileName = "records.txt";//fileName = "records.txt"
   final int MAX = 10;//Set MAX number of records
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   String input;
   JTextField field = new JTextField();
   JTextArea display = new JTextArea();
   Search si = new Search();
   Sort s = new Sort();
   int xSize1 = 300,ySize1 = 500;
   JTextField passLabel = new JTextField("      Enter your password");
   JPasswordField passField = new JPasswordField();
   
   
   private Smoke2 create() 
   {
       frame = createFrame();
       frame.getContentPane().add(createContent());
       return this;
   }

   private JFrame createFrame() 
   {
       JFrame frame = new JFrame(getClass().getName());
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       return frame;
   }
    
   private JFrame createFrame2() 
   {
       JFrame frame2 = new JFrame(getClass().getName());
       frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       return frame2;
   }

   private void show()
   {
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
   }
   
   private void frame2()
   {
      frame2 = createFrame2();
      frame2.getContentPane().add(createContent2());
      frame2.pack();
      frame2.setLocationRelativeTo(null); 
      frame2.setVisible(true);
   }

   private Component createContent() 
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
      passField.setBounds(295,350,100,30);

      panel.add(passField);     
     
      input = passField.getText();

      passField.setBounds(70,150,150,30);
      panel.add(passField);
      
      passLabel.setOpaque(false);
      passLabel.setBounds(70,120,150,30);
      passLabel.setBorder(null);
      panel.add(passLabel);
      passLabel.setEditable(false); 
      
      panel.add(passField);
      
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
         
        panel.setPreferredSize(new Dimension(xSize1, ySize1));

        return panel;
    }// end create component

    private Component createContent2() 
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
              
  //    JButton Search = new JButton("Search");
      JButton Search = new JButton("Search");                 
      JButton Launch = new JButton("Launch");
      JButton SortN = new JButton("By Name");
      JButton SortA = new JButton("By Author");      
      JButton SortD = new JButton("By Difficulty");    
      JButton Quit = new JButton("Quit");  
      JButton Refresh = new JButton("Refresh");     
      Search.setBounds(70,430,100,30);      
      Launch.setBounds(295,430,100,30);
      SortN.setBounds(70,320,100,30);
      SortA.setBounds(220,320,100,30);      
      SortD.setBounds(370,320,100,30);
      Quit.setBounds(520,430,100,30);  
      Refresh.setBounds(520,320,100,30);    
      panel.add(Search);      
      panel.add(Launch);
      panel.add(SortN);
      panel.add(SortA);      
      panel.add(SortD);
      panel.add(Quit); 
      panel.add(Refresh);     
      
      display.setEditable(false);
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < info.length; i++)
      {
         for(int j = 0; j < info[0].length; j++)
         {
            sb.append(info[i][j] + "\t");
         }
         sb.append("\n");
      }
      display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
      display.append(sb.toString());
      display.setOpaque(false);
      JScrollPane scrollPane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBounds(70, 120, 560, 160);
      scrollPane.getViewport().setOpaque(false);
      scrollPane.setOpaque(false);
      panel.add(scrollPane);       
      
      field.setEditable(true);      
      field.setBounds(295,380,100,30);
      panel.add(field);
      
      Search.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {                          
            Add a = new Add();
            KeyInput ki = new KeyInput();
            si.searchGame(fileName, info, 0);
            
         }
      });
      
      SortN.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //frame2.dispose();// close the current frame
            display.setText("");
            sorting(0);
         }
      });// end Sort ActionListener
      
      SortA.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //frame2.dispose();// close the current frame
            display.setText("");
            sorting(5);
         }
      });// end Sort ActionListener
      
      SortD.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            //frame2.dispose();// close the current frame
            display.setText("");
            sorting(2);
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
               game4();
            }
         }
      });// end Launch ActionListener
       
       Refresh.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
           frame2.dispose();
           frame2();
         }
        });   
       Quit.addActionListener(new ActionListener()
       {      
          public void actionPerformed(ActionEvent e)
          {
             System.exit(0);
          }
      });// end Quit ActionListener
        
        panel.setPreferredSize(new Dimension(700, 500));

        return panel;
    }// end create component2
 
    private Image requestImage()
    {
        Image image = null;

        try 
        {
            image = ImageIO.read(new File("aa.jpg"));
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

        return image;
    }
    
      public void game1()
      {
         JFrame f = new JFrame("game1");
         first s = new first();
         f.setSize(800,600);    
         f.add(s);
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         f.setLocationRelativeTo(null);
         f.setVisible(true);
      }
      
      public void game2()
      {
         JFrame f = new JFrame("game2");
         second s = new second();
         f.setSize(800,600);    
         f.add(s);
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         f.setLocationRelativeTo(null);
         f.setVisible(true);
      }
      
      public void game3()
      {
         JFrame f = new JFrame("game3");
         third s = new third();
         f.setSize(800,600);    
         f.add(s);
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         f.setLocationRelativeTo(null);
         f.setVisible(true);
      }
      
      public void game4()
      {
         JFrame f = new JFrame("game4");
         fourth s = new fourth();
         f.setSize(800,600);    
         f.add(s);
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         f.setLocationRelativeTo(null);
         f.setVisible(true);
      }
      
      public void sorting(int a)
      {
         info = s.sortGame(info,a);
         StringBuilder sb2 = new StringBuilder();
         for (int  i = 0; i < info.length; i++)
         {
            for (int  j = 0; j < 6; j++)
            {
               if (rows[i] !=null)
               {
                  sb2.append(info[i][j] + "\t");
               }
            }
            sb2.append("\n");
         }
         display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
         display.append(sb2.toString().trim());
      }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new Smoke2().create().show();
            }
        });
    }
}