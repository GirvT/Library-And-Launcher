//Author: Girvan Tse
//Date : 05/03/17
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
@author Girvan Tse
"JavaClassLoader" extends ClassLoader and attempts to load classes and methods based on the inputted
class names and method names.
*/
 
public class JavaClassLoader extends ClassLoader {
	/**
   "invokeClassMethod" attempts to execute a method based on the loaded class name.
   @param classBinName is the binary name of the class that might exist
   @param methodName is the method name of the class to be executed
   */
	public void invokeClassMethod(String classBinName, String methodName){
		
		try {
			
			// Create a new JavaClassLoader 
			ClassLoader classLoader = this.getClass().getClassLoader();
			
			// Load the target class using its binary name
	        Class<?> loadedMyClass = classLoader.loadClass(classBinName);
	        	        
	        // Create a new instance from the loaded class
	        Constructor<?> constructor = loadedMyClass.getConstructor();
	        Object myClassObject = constructor.newInstance();
	        
	        // Getting the target method from the loaded class and invoke it using its name
	        Method method = loadedMyClass.getMethod(methodName);
	        method.invoke(myClassObject);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}