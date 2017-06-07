//Filename: KeyInput.java
//Author: Girvan Tse & Manish Suresh
//Date : 05/03/17

import java.io.*;

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
   public static String entries()
   {
      DataInput keyboard = new DataInputStream(System.in);
      try{
         System.out.println("Enter Game Name");
         input = keyboard.readLine();
         txt = input;//Store name
         items[0] = input;
         int index = 1; // Get next item index 1 to 5
         while((input != null) && index < 6) 
         {
            switch (index)
            {
               case 1:System.out.println("Enter Filename");
                     break;
               case 2:System.out.println("Enter Difficulty");
                     break;
               case 3:System.out.println("Enter Date of creation");
                     break;
               case 4:System.out.println("Enter Star Raiting");
                     break;        
               case 5:System.out.println("Enter Publisher");
                     break;
            }
            input = keyboard.readLine();
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
         
              