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

public class Smoke2 {
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

    private Smoke2 create() {
        frame = createFrame();
        frame.getContentPane().add(createContent());
        return this;
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame(getClass().getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }
    
    private JFrame createFrame2() {
        JFrame frame2 = new JFrame(getClass().getName());
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame2;
    }

    private void show() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Component createContent() {
        final Image image = requestImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
         
         panel.setLayout(null);
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
               frame.dispose();
               frame2 = createFrame2();
               frame2.getContentPane().add(createContent2());
               frame2.pack();
               frame2.setLocationRelativeTo(null); 
               frame2.setVisible(true);
            }
         });// end Start actionListener
         
         Quit.addActionListener(new ActionListener()
         {      
            public void actionPerformed(ActionEvent e)
            {
               System.exit(0);
            }
         });
         
        panel.setPreferredSize(new Dimension(700, 500));

        return panel;
    }

    private Component createContent2() {
        final Image image = requestImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
         
         panel.setLayout(null);
               
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
      display.setOpaque(false);
      //display.setBackground(new Color(red, green, blue, alpha));
      JScrollPane scrollPane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBounds(70, 120, 560, 160);
      scrollPane.getViewport().setOpaque(false);
      scrollPane.setOpaque(false);
      panel.add(scrollPane);       
      
      field.setEditable(true);      
      field.setBounds(295,350,100,30);
      panel.add(field);
            
      

      
      Sort.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            frame2.dispose();// close the current fram
            //sortFrame();// open the frame used for sorting
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
        
        panel.setPreferredSize(new Dimension(700, 500));

        return panel;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Smoke2().create().show();
            }
        });
    }
}