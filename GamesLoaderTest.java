

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
         if ( gameInput.toLowerCase().indexOf(info[x][1].toLowerCase()) != -1 ) {
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