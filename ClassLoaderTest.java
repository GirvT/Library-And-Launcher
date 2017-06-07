

/**
 * @author ashraf
 * 
 */
public class ClassLoaderTest extends JavaClassLoader {

   public void start(String load)
   {
      if(load == "SearchFrame")
      {
         JavaClassLoader javaClassLoader = new JavaClassLoader();
		   javaClassLoader.invokeClassMethod("Smoke2", "searchFrame");   
      }
      if(load == "MainFrame")
      {
         JavaClassLoader javaClassLoader = new JavaClassLoader();
		   javaClassLoader.invokeClassMethod("Smoke2", "mainFrame");
      }
      if(load == "AddFrame")
      {
         JavaClassLoader javaClassLoader = new JavaClassLoader();
		   javaClassLoader.invokeClassMethod("Smoke2", "addFrame");
      }
      if(load == "DeleteFrame")
      {
         JavaClassLoader javaClassLoader = new JavaClassLoader();
		   javaClassLoader.invokeClassMethod("Smoke2", "deleteFrame");
      }
   }
	public static void main(String[] args) 
   {
      new ClassLoaderTest();	
	}
	
}