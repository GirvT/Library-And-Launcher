import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Smoke2 
{
   private JFrame frame, mainFrame, searchFrame, deleteFrame;
   String nameArray[] = new String[6];
   static String fileName = "records.txt";//fileName = "records.txt"
   final int MAX = 10;//Set MAX number of records
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   JTextArea display = new JTextArea();
   Search si = new Search();
   Sort s = new Sort();
   int xSize1 = 300,ySize1 = 500;
   JTextField passLabel = new JTextField("\t" + "Enter your password");
   JPasswordField passField = new JPasswordField();
   String input, st, ss, search_input;
   ClassLoaderTest cl = new ClassLoaderTest();
   
   
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
       JFrame mainFrame = new JFrame(getClass().getName());
       mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       return mainFrame;
   }
   
   private JFrame createFrame3() 
   {
       JFrame searchFrame = new JFrame(getClass().getName());
       searchFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       return searchFrame;
   }

   private JFrame createFrame4() 
   {
       JFrame deleteFrame = new JFrame(getClass().getName());
       deleteFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       return deleteFrame;
   } 
   
   private void show()
   {
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
   }
   
   private void mainFrame()
   {
      mainFrame = createFrame2();
      mainFrame.getContentPane().add(createContent2());
      mainFrame.pack();
      mainFrame.setLocationRelativeTo(null); 
      mainFrame.setVisible(true);
   }
   
  private void searchFrame()
   {
      searchFrame = createFrame3();
      searchFrame.getContentPane().add(createContent3());
      searchFrame.pack();
      searchFrame.setLocationRelativeTo(null); 
      searchFrame.setVisible(true);
   }
   
   private void deleteFrame()
   {
      deleteFrame = createFrame4();
      deleteFrame.getContentPane().add(createContent4());
      deleteFrame.pack();
      deleteFrame.setLocationRelativeTo(null); 
      deleteFrame.setVisible(true);
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
      
      ImageIcon login = new ImageIcon("login.png");
      JButton Login = new JButton("Login",login);
      JButton Quit = new JButton("Quit");       
      JTextPane pane = new JTextPane ();
      
      pane.insertIcon (new ImageIcon("steam.png"));
      pane.setEditable(false);
      pane.setOpaque(false);
      pane.setBounds(100,20,250,150);
      
      Login.setBounds(85,300,120,40);
      Login.setBackground(new Color(59, 89, 182));
      Login.setForeground(Color.WHITE);
      Login.setFocusPainted(false);
      Login.setFont(new Font("Tahoma", Font.BOLD, 12));
      Login.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      Login.setHorizontalAlignment(SwingConstants.RIGHT);
      Login.setHorizontalTextPosition(SwingConstants.LEFT);
      
      Quit.setBackground(new Color(255, 10, 10));
      Quit.setForeground(Color.WHITE);
      Quit.setFocusPainted(false);
      Quit.setFont(new Font("Tahoma", Font.BOLD, 12));
      Quit.setBounds(85,350,120,40);
      
      passField.setEditable(true);      
      passField.setBounds(295,350,100,30);
      passField.setBounds(70,150,150,30);
           
      passLabel.setBounds(70,120,150,30);
      passLabel.setBorder(null);
      passLabel.setOpaque(false);
      passLabel.setEditable(false); 
      passLabel.setForeground(new Color(234, 234, 225));
      
      panel.add(pane);
      panel.add(Login);
      panel.add(Quit);
      panel.add(passField);
      panel.add(passLabel);
      
      input = passField.getText();
      
      Login.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            input = passField.getText();
            if (input.equals(""))
            {
               frame.dispose();
               JOptionPane.showMessageDialog(null, "Login Sucessful!");
               mainFrame();
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
              
      JButton Search = new JButton("Search");   
      JButton Add = new JButton("Add");      
      JButton Delete = new JButton("Delete");        
      JButton Launch = new JButton("Launch");
      JButton SortN = new JButton("Sort by Name");
      JButton SortA = new JButton("Sort by Author");      
      JButton SortD = new JButton("Sort by Difficulty");    
      JButton Quit = new JButton("Quit");  
      JButton Refresh = new JButton("Refresh");     
      
      Refresh.setFocusPainted(false);
      Refresh.setContentAreaFilled(false);
      Refresh.setForeground(new Color(234, 234, 225));
      
      Delete.setFocusPainted(false);
      Delete.setContentAreaFilled(false);
      Delete.setForeground(new Color(234, 234, 225));
      
      Add.setFocusPainted(false);
      Add.setContentAreaFilled(false);
      Add.setForeground(new Color(234, 234, 225));
      
      Search.setFocusPainted(false);
      Search.setContentAreaFilled(false);
      Search.setForeground(new Color(234, 234, 225));
      
      SortN.setFocusPainted(false);
      SortN.setContentAreaFilled(false);
      SortN.setForeground(new Color(234, 234, 225));
      
      SortA.setFocusPainted(false);
      SortA.setContentAreaFilled(false);
      SortA.setForeground(new Color(234, 234, 225));
      
      SortD.setFocusPainted(false);
      SortD.setContentAreaFilled(false);
      SortD.setForeground(new Color(234, 234, 225));
      
      Launch.setFocusPainted(false);
      Launch.setContentAreaFilled(false);
      Launch.setForeground(new Color(234, 234, 225));
      
      SortN.setBounds(70,300,120,30);     
      SortA.setBounds(225,300,120,30);
      Launch.setBounds(380,40,100,30);
      SortD.setBounds(380,300,120,30);
      Add.setBounds(70,40,100,30);      
      Search.setBounds(530,300,100,30);  
      Refresh.setBounds(530,40,100,30);    
      Delete.setBounds(220,40,100,30);  
            
      display.setEditable(false);
      display.setText("");
      loading();
      display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
      display.append(st);
      display.setOpaque(false);
      display.setForeground(new Color(234, 234, 25));

      JScrollPane scrollPane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBounds(70, 80, 560, 200);
      scrollPane.getViewport().setOpaque(false);
      scrollPane.setOpaque(false);
      
      panel.add(Search);   
      panel.add(Add);
      panel.add(Delete);   
      panel.add(Launch);
      panel.add(SortN);
      panel.add(SortA);      
      panel.add(SortD); 
      panel.add(Refresh); 
      panel.add(scrollPane);       
           
      Search.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {   
            mainFrame.dispose();
            searchFrame();                       
            searchGame(fileName, info, 0);           
         }
      });
      
      SortN.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            display.setText("");
            sorting(0);
         }
      });// end Sort ActionListener
      
      SortA.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            display.setText("");
            sorting(5);
         }
      });// end Sort ActionListener
      
      SortD.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            display.setText("");
            sorting(2);
         }
      });// end Sort ActionListener
      
       display.addMouseListener(new MouseAdapter() 
       {
         @Override
         public void mouseClicked(MouseEvent e) 
         {
            if (e.getButton() != MouseEvent.BUTTON1) {
               return;
            }
            if (e.getClickCount() != 1) 
            {
               return;
            }
            int offset = display.viewToModel(e.getPoint());
            try 
            {
               int rowStart = Utilities.getRowStart(display, offset);
               int rowEnd = Utilities.getRowEnd(display, offset);
               String selectedLine = display.getText().substring(rowStart, rowEnd);
               input = selectedLine.trim();
               System.out.println(input);

            } catch (BadLocationException e1)
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
               //game1();
               cl.loader("game1");
            }
            else if (input2.equals("BoxMazegame2105/02/2017*****Manish"))
            {
               //game2();
               cl.loader("game2");
            }
            else if (input2.equals("Mazegame3305/02/17**Luciano"))
            {
               //game3();
               cl.loader("game3");
            }
            else if (input2.equals("GuessMastergame4505/18/2017*****Keith"))
            {
               //game4();
               cl.loader("games4");
            }
            else 
            {
               JOptionPane.showMessageDialog(null, "Game does not exist, please try a different one.");
            }
            
         }
      });// end Launch ActionListener
       
       Refresh.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
            display.setText("");
            loading();
            display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
            display.append(st);
         }
        });  
                 
       Quit.addActionListener(new ActionListener()
       {      
          public void actionPerformed(ActionEvent e)
          {
             System.exit(0);
          }
      });// end Quit ActionListener
        
        panel.setPreferredSize(new Dimension(700, 375));

        return panel;
    }// end create component2
 
      private Component createContent3() 
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
         
         JTextField userInput = new JTextField();
         JTextArea display2 = new JTextArea();
         JTextArea display3 = new JTextArea();
         JButton Search = new JButton("Search");
         JButton Launch = new JButton("Launch");
         JButton Home = new JButton("Home");
         
         display2.setText("What would you like to search?");
         display2.setEditable(false);
         display2.setOpaque(false);
         display2.setForeground(new Color(234, 234, 225));

         display3.setText("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
         display3.setEditable(false);
         display3.setOpaque(false);
         display3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE),BorderFactory.createEmptyBorder(10, 10, 10, 10)));         
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
            
         Search.setBounds(300,300,100,30);
         Home.setBounds(100,320,100,30);
         display2.setBounds(270,200,180,40);
         userInput.setBounds(300,250,100,30);
         display3.setBounds(70,60,560,100);
         Launch.setBounds(500,320,100,30);
         
         panel.add(display2);
         panel.add(Search);
         panel.add(display3);
         panel.add(userInput);
         panel.add(Home);
         panel.add(Launch);
         
              
      Search.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  display.setText("");                  
            search_input = userInput.getText();     
            searchGame(fileName, info, 0);
            display3.setText("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
            display3.append(ss);         
         }
      });
      
      Home.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {  
            searchFrame.dispose();
            mainFrame();         
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
            if (input2.equals("MazeBoxgame1205/02/17***Keith"))
            {
               game1();
            }
            else if (input2.equals("BoxMazegame2105/02/2017*****Manish"))
            {
               game2();
            }
            else if (input2.equals("Mazegame3305/02/17**Luciano"))
            {
               game3();
            }
            else if (input2.equals("GuessMastergame4505/18/2017*****Keith"))
            {
               game4();
            }
            else 
            {
               JOptionPane.showMessageDialog(null, "Game does not exist, please try a different one.");
            }
            
         }
      });// end Launch ActionListener
               
         panel.setPreferredSize(new Dimension(700, 375));

        return panel;
      }
      
      private Component createContent4() 
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
         panel.setPreferredSize(new Dimension(700, 375));

        return panel;
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
      
      public String loading()
      {
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
         st = sb.toString();
         return st;
      }   
      
      public String searchGame(String fileName, String data[][], int item)
      {
         DataInput d = new DataInputStream(System.in);
         String input;
         Search s = new Search();
         StringBuilder sb = new StringBuilder();
            input = search_input;
            if(input != null)
            {
               boolean found = false;
               for(int i = 0; i < data.length; i++)//Search for record
               {
                  if(data[i][item].equals(input))
                  {
                     found = true;
                     for(int k = 0; k < 6; k++)
                     {
                        sb.append(data[i][k] + "\t"); //output entire record
                     }
                     sb.append("\n");
                  }//end if
               }//end loop
               if(!found)
               {
               }  
            }
            ss = sb.toString();
            return ss;
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