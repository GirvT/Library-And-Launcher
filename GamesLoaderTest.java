

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
         if ( gameInput.toLowerCase().contains(info[x][1].toLowerCase()) ) {
            {
            System.out.println("I found the keyword");
            gg.Game(info[x][1]);
            break;
            }        
         } else {
            System.out.println("not found");
         }
      } 

   }	
}