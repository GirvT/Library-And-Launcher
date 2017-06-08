import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;
 
public class LoginPanel extends JPanel
{
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   Smoke sMain = new Smoke();
   
   JTextField passLabel = new JTextField("Enter your Login Info");
   JTextField userField = new JTextField("Manish");
   JPasswordField passField = new JPasswordField("sss");

   static String accountsName = "accounts.txt";//fileName = "records.txt"

   final int MAX = 10;//Set MAX number of records
   int xSize1 = 300,ySize1 = 500;

   String input, input2;
   String rows2[] = new String[MAX];//Store max 20 records
   String info2[][] = new String[MAX][3];//Store records in 2d array
   
   public LoginPanel (final JFrame Frame)
   {
      login(Frame);
   }
   
   public void login(final JFrame frame)
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
      passField.setBounds(70,220,150,30);
      
      userField.setEditable(true);
      userField.setBounds(70,180,150,30);
           
      passLabel.setBounds(70,120,150,30);
      passLabel.setBorder(null);
      passLabel.setOpaque(false);
      passLabel.setEditable(false); 
      passLabel.setForeground(new Color(234, 234, 225));
      passLabel.setHorizontalAlignment(SwingConstants.CENTER);
      
      panel.add(pane);
      panel.add(Login);
      panel.add(Quit);
      panel.add(passField);
      panel.add(userField);
      panel.add(passLabel);
      add(panel);
      
      Login.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         { 
            rows2 = rd.readFile(accountsName, 3);
            info2 = re.getRecords(rows2);
            input = userField.getText();
            input2 = passField.getText();
            if (input.equals(info2[0][0]))
            {
               if (input2.equals(info2[0][1]))
               {
                  frame.dispose();
                  JOptionPane.showMessageDialog(null, "Login Sucessful!");
                  sMain.mainFrame(info2[0][2]);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Incorrect Password, please try again.");
               }
            }
            else if (input.equals(info2[1][0]))
            {
               if (input2.equals(info2[1][1]))
               {
                  frame.dispose();
                  JOptionPane.showMessageDialog(null, "Login Sucessful!");
                  sMain.mainFrame(info2[1][2]);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Incorrect Password, please try again.");
               }
            }
            else if (input.equals(info2[2][0]))
            {
               if (input2.equals(info2[2][1]))
               {
                  frame.dispose();
                  JOptionPane.showMessageDialog(null, "Login Sucessful!");
                  sMain.mainFrame(info2[2][2]);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Incorrect Password, please try again.");
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Incorrect UserName or Password, please try again.");
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