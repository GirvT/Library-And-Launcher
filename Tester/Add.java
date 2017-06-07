//Filename: NewRecord.java
//Author: Girvan Tse & Manish Suresh
//Date : 05/03/17

import java.io.*;

/**
NewRecord class inserts a new profile into the LTS system.
@author Girvan Tse & Manish Suresh
*/

class Add
{
   /**
   Add a record into the LTS system
   @param fileName The name of the text file which the data NewRecord will manipulate
   @param newRec The data of the profile (in the form of KeyInput) that the new record will contain
   */
   public static void addGame(String fileName, String newRec)
   {
      String data[]= new String[20];
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