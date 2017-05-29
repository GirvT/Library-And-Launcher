import java.lang.reflect.*;
import java.lang.Class;

public class classAddTest
{  
   public static void main(String[] args) throws Exception
   {
   
   //Name and paramaters of the class
   int param1 = 1;
   boolean param2 = true;
   String className = "Class1";
   
   //Turn className into a class with name className
   Class cl = Class.forName(className);
   
   //Create a constructor of the class
   Constructor con = cl.getConstructor(int.class, boolean.class);
   
   //Set Object xyz to a instance of the class 
   Object a = con.newInstance(param1, param2);
   
   /*
   ----------------------------------
   */
   
   //Method example
   int MyVar = 2;
   String methodName = "Method1";
   Method m = a.getClass().getMethod(methodName + MyVar);
   //attempts to do Method12();
   m.invoke(a);

   }
}