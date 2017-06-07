import javax.swing.*;
import java.awt.*;

public class Smoke2 
{
   private JFrame frame, mainFrame, searchFrame, addFrame, deleteFrame;
      
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
      JFrame addFrame = new JFrame(getClass().getName());
      addFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      return addFrame;
   }
    
   private JFrame createFrame5() 
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
   
   public void mainFrame()
   {
      mainFrame = createFrame2();
      mainFrame.getContentPane().add(createContent2());
      mainFrame.pack();
      mainFrame.setLocationRelativeTo(null); 
      mainFrame.setVisible(true);
   }
   
   public void searchFrame()
   {
      searchFrame = createFrame3();
      searchFrame.getContentPane().add(createContent3());
      searchFrame.pack();
      searchFrame.setLocationRelativeTo(null); 
      searchFrame.setVisible(true);
   }
   
   public void addFrame()
   {
      addFrame = createFrame4();
      addFrame.getContentPane().add(createContent4());
      addFrame.pack();
      addFrame.setLocationRelativeTo(null); 
      addFrame.setVisible(true);
   }
   
   public void deleteFrame()
   {
      deleteFrame = createFrame5();
      deleteFrame.getContentPane().add(createContent5());
      deleteFrame.pack();
      deleteFrame.setLocationRelativeTo(null); 
      deleteFrame.setVisible(true);
   }

   private JPanel createContent() 
   {
      LoginPanel login = new LoginPanel(frame);
      return login ;
   }// end create component

   private Component createContent2() 
   {
      MainPanel main = new MainPanel(mainFrame);
      return main;  
   }// end create component2
 
   private Component createContent3() 
   {
      SearchPanel search = new SearchPanel(searchFrame);
      return search;
   }
         
   private Component createContent4() 
   {
      AddPanel add = new AddPanel(addFrame) ;
      return add;
   }
   
    private Component createContent5() 
   {
      DeletePanel delete = new DeletePanel(deleteFrame) ;
      return delete;
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