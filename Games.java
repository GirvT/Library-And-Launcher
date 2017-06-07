import javax.swing.*;
import java.awt.*;

public class Games
{
   JFrame Frame1 = new JFrame("game1");
   JFrame Frame2 = new JFrame("game2");
   JFrame Frame3 = new JFrame("game3");
   JFrame Frame4 = new JFrame("game4");
   
   public void Game(String game)
   {
   if (game.equals("game1"))
   {   
      first s = new first(Frame1);
      Frame1.setSize(800,600);    
      Frame1.getContentPane().add(s);
      Frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      Frame1.setLocationRelativeTo(null);
      Frame1.setVisible(true);
   }
   else if (game.equals("game2"))
   {   
      second s = new second();
      Frame2.setSize(800,600);    
      Frame2.getContentPane().add(s);
      Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      Frame2.setLocationRelativeTo(null);
      Frame2.setVisible(true);
   }
      
   else if (game.equals("game3"))
   {
      third s = new third();
      Frame3.setSize(800,600);    
      Frame3.add(s);
      Frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      Frame3.setLocationRelativeTo(null);
      Frame3.setVisible(true);
   }
    
   else if (game.equals("game4"))
   {
      fourth s = new fourth();
      Frame4.setSize(800,600);    
      Frame4.add(s);
      Frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      Frame4.setLocationRelativeTo(null);
      Frame4.setVisible(true);
   }
   else
   {
      JOptionPane.showMessageDialog(null, "Game does not exist, please try a different one.");
    }    
}
}