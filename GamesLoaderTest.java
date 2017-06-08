

/**
 * @author ashraf
 * 
 */
public class GamesLoaderTest extends JavaClassLoader {
   Games gg = new Games();   

   public void load(String gameInput, String info[][])
   { 
      for (int x = 0; x < info.length; x++)
      {
         System.out.println(gameInput);
         if ( gameInput.toLowerCase().contains(info[x][1].toLowerCase()))
         {
            if ( gameInput.toLowerCase().contains(info[x][2].toLowerCase())) 
            {
               JavaClassLoader javaClassLoader = new JavaClassLoader();
   		      javaClassLoader.invokeClassMethod(info[x][1], info[x][2]);
               break;
            } 
         }
         else 
         {
            System.out.println("not found");
         }
      } 

   }	
}