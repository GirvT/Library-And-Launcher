import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;
 
public class MainPanel extends JPanel
{
   GamesLoaderTest gl = new GamesLoaderTest();
   ReadData rd = new ReadData();//Instantiate the class ReadData
   Records re = new Records();//Instantiate the class Records
   Sort s = new Sort();
   Add ad = new Add();
   Smoke2 sMain = new Smoke2();
   HelpBox help = new HelpBox();
   
   static String fileName = "records.txt";//fileName = "records.txt"
   static String logName = "log.txt";//fileName = "records.txt"

   JTextArea display = new JTextArea();
   DefaultHighlighter highlighter =  (DefaultHighlighter)display.getHighlighter();
   DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.GRAY );
   
   String input, st;
   final int MAX = 10;//Set MAX number of records
   int line = 0;
   String rows[] = new String[MAX];//Store max 20 records
   String info[][] = new String[MAX][6];//Store records in 2d array
      
   public MainPanel(final JFrame Frame, final String access)
   {
      main(Frame,access);
   }
   
   public void main(final JFrame frame, final String Access)
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
      JButton Help = new JButton("Help"); 
      JButton Launch = new JButton("Launch");
      JButton SortN = new JButton("Sort by Name");
      JButton SortA = new JButton("Sort by Author");
      JButton SortR = new JButton("Sort by Date");      
      JButton SortD = new JButton("Sort by Difficulty");    
      JButton Quit = new JButton("Quit");  
      JButton Refresh = new JButton("Refresh");     
      
      Refresh.setFocusPainted(false);
      Refresh.setContentAreaFilled(false);
      Refresh.setForeground(new Color(234, 234, 225));
            
      Search.setFocusPainted(false);
      Search.setContentAreaFilled(false);
      Search.setForeground(new Color(234, 234, 225));
      
      SortN.setFocusPainted(false);
      SortN.setContentAreaFilled(false);
      SortN.setForeground(new Color(234, 234, 225));
      
      SortA.setFocusPainted(false);
      SortA.setContentAreaFilled(false);
      SortA.setForeground(new Color(234, 234, 225));
      
      SortR.setFocusPainted(false);
      SortR.setContentAreaFilled(false);
      SortR.setForeground(new Color(234, 234, 225));
      
      SortD.setFocusPainted(false);
      SortD.setContentAreaFilled(false);
      SortD.setForeground(new Color(234, 234, 225));
      
      Launch.setFocusPainted(false);
      Launch.setContentAreaFilled(false);
      Launch.setForeground(new Color(234, 234, 225));
      
      Help.setFocusPainted(false);
      Help.setContentAreaFilled(false);
      Help.setForeground(new Color(234, 234, 225));
      
      SortN.setBounds(70,40,120,30);     
      SortA.setBounds(215,40,120,30);
      SortR.setBounds(510,40,120,30);
      SortD.setBounds(360,40,130,30);            
      Search.setBounds(70,290,100,30);
      Refresh.setBounds(530,290,100,30); 
      Launch.setBounds(300,350,100,30);  
      Help.setBounds(0,0, 60,20);

            
      display.setEditable(false);
      display.setText("");
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
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
      panel.add(Launch);
      panel.add(SortN);
      panel.add(SortA); 
      panel.add(SortD);     
      panel.add(SortR); 
      panel.add(Refresh); 
      panel.add(scrollPane); 
      panel.add(Help);
      add(panel);      
           
      Search.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {   
            frame.dispose();
            sMain.searchFrame(Access);                      
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
      
      SortR.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            display.setText("");
            sorting(3);
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
               int line_max = display.getLineCount();
               int count = display.getLineEndOffset(line_max - 1);
               // begin To clear the previous selesction
               display.setText("");
               loading();
               display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
               display.append(st);
               // end To clear the previous selesction
               int rowStart = Utilities.getRowStart(display, offset);
               int rowEnd = Utilities.getRowEnd(display, offset);
               String selectedLine = display.getText().substring(rowStart, rowEnd);
               input = selectedLine;
               String input3 = input.replaceAll("\\s","");
              /* System.out.println(input);
               System.out.println("offset :" +offset);
               System.out.println("count :" +count);
               System.out.println(display.getLineOfOffset(offset));*/
               //If is used for avoiding selection of blank line
               if (offset < count)
               {
                  int line = display.getLineOfOffset(offset);
                  int start =  display.getLineStartOffset(line);
                  int end =    display.getLineEndOffset(line);
                  highlighter.addHighlight(start, end, painter);
               }

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
            String input2 = input;
            
            rows = rd.readFile(fileName, 10);
            info = re.getRecords(rows);
            gl.load(input2, info);
         }
      });// end Launch ActionListener
       
       Refresh.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
            display.setText("");
            loading();
            display.append("     |Name|" + "\t|FileName|" + "\t|Method Name|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
            display.append(st);
         }
        });  
            
           
      Help.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
          help.helpbox();  
         }
           
      });
                 
       Quit.addActionListener(new ActionListener()
       {      
          public void actionPerformed(ActionEvent e)
          {
             System.exit(0);
          }
      });// end Quit ActionListener
      
      if (Access.equals("Admin"))
      {  
         JButton Add = new JButton("Add");      
         JButton Delete = new JButton("Delete"); 
         
         Delete.setFocusPainted(false);
         Delete.setContentAreaFilled(false);
         Delete.setForeground(new Color(234, 234, 225));
      
         Add.setFocusPainted(false);
         Add.setContentAreaFilled(false);
         Add.setForeground(new Color(234, 234, 225));
         
         Add.setBounds(225,290,100,30);           
         Delete.setBounds(380,290,100,30);
        
         panel.add(Add);
         panel.add(Delete);
         
         Add.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {   
               frame.dispose();
               sMain.addFrame(Access);                       
            }
         });
      
         Delete.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {   
               frame.dispose();
               sMain.deleteFrame(Access);                       
            }
         }); 
      }
        
        panel.setPreferredSize(new Dimension(700, 400));

   }
  
  public String loading()
      {
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < info.length; i++)
         {
            for(int j = 0; j < info[0].length; j++)
            {
               sb.append(info[i][j] + "\t");
            }
            sb.append("\n");
         }
         st = sb.toString().trim();
         return st;
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