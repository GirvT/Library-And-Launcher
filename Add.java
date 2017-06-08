//Author: Girvan Tse 
//Date : 08/06/17

import java.io.*;

/**
@author Girvan Tse 
Add class takes string input and turns it into an array. Then the string input is added to the records file.
*/

class Add
{
   /**
   "addGame" adds an new entry into the records data text file.
   @param fileName The name of the text file which the data will be saved into.
   @param newRec The data to be added to the new entry (in the form of KeyInput) that the new record will contain.
   */
   public static void addGame(String fileName, String newRec)
   {
      String data[]= new String[20]; //max 20 characters per input
      int count = 0;
      int a = 0;
      try
      {
         DataInput f1 = new DataInputStream(new FileInputStream(fileName));
         String txt = f1.readLine();
         while(txt != null)//Read all records from file
         {
            data[a++] = txt;
            txt = f1.readLine();
            ++count;
         }
         DataOutput f2 = new DataOutputStream(new FileOutputStream(fileName));
         for(int i = 0; i < count; i++)
         {
            f2.writeBytes(data[i] + "\r\n"); //Write to file
         }
            f2.writeBytes(newRec);//insert new record     
      }
      catch(Exception e)
      {
      }
   }//end addRecord
}//end newRecord