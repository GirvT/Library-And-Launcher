import javax.swing.*;

/**
 * @author ashraf
 * 
 */
public class GamesLoader extends JavaClassLoader {

   int x;
   
   public void load(String gameInput, String info[][])
   { 
      for ( x = 0; x < info.length; x++)
      {
         if ( gameInput.toLowerCase().contains(info[x][1].toLowerCase()))
         {
            if ( gameInput.toLowerCase().contains(info[x][2].toLowerCase())) 
            {
               JavaClassLoader javaClassLoader = new JavaClassLoader();
   		      javaClassLoader.invokeClassMethod(info[x][1], info[x][2]);
               break;
            } 
         }
      } 
      
      if ( gameInput.toLowerCase().contains(info[x][1].toLowerCase()))
      {
         if ( gameInput.toLowerCase().contains(info[x][2].toLowerCase())) 
         {

         } 
         else
         {
         JOptionPane.showMessageDialog(null, "Game not found");
         }
      } 
   }	
}