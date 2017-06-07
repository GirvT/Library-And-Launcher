
//Filename: KeyInput.java
//Author: Girvan Tse & Manish Suresh
//Date : 05/03/17

import java.io.*;
import javax.swing.*;

/**
KeyInput class uses the .entries() method to take keyboard input data in a 
specific form for the NewRecord class to use
@author Girvan Tse & Manish Suresh
*/

class KeyInput
{
   static String txt, input;
   static String items[] = new String[6];
   /**
   Start taking keyboard input data in a form the NewRecord class can use
   */
   public static String entries( JTextField add1, JTextField add2, JTextField add3, JTextField add4, JTextField add5, JTextField add6)
   {
      DataInput keyboard = new DataInputStream(System.in);
      try{
         input = add1.getText();
         txt = input;//Store name
         items[0] = input;
         int index = 1; // Get next item index 1 to 5
         while((input != null) && index < 6) 
         {
            switch (index)
            {
               case 1:input = add2.getText();
                     break;
               case 2:input = add3.getText();
                     break;
               case 3:input = add4.getText();
                     break;
               case 4:input = add5.getText();
                     break;        
               case 5:input = add6.getText();
                     break;
            }
            txt += "#" + input;
            items[index] = input;
            index++;
         }//end while
         System.out.println("\nNew record complete.");
         System.out.println(txt);
      }
      catch(Exception e)
      {
      }
      return txt;
   }// end entries
}//end KeyInput
         
              