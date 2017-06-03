/**
 * @author ashraf
 * 
 */
public class ClassLoaderTest extends JavaClassLoader {
   
	public void loader(String game)
   
   {
      if (game == "game1")
      {
		JavaClassLoader javaClassLoader = new JavaClassLoader();
		javaClassLoader.invokeClassMethod("Smoke2", "game1");
		}
      if (game == "game2")
      {
		JavaClassLoader javaClassLoader = new JavaClassLoader();
		javaClassLoader.invokeClassMethod("Smoke2", "game2");
		}
      if (game == "game3")
      {
		JavaClassLoader javaClassLoader = new JavaClassLoader();
		javaClassLoader.invokeClassMethod("Smoke2", "game3");
		}
      if (game == "game4")
      {
		JavaClassLoader javaClassLoader = new JavaClassLoader();
		javaClassLoader.invokeClassMethod("Smoke2", "game4");
		}
	}
	public static void main(String[] args)
   {
   
   }
}