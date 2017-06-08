//Author: Girvan Tse
//Date : 05/03/17

import java.io.*;

/**
@author Girvan Tse 
Delete class searches for data and proceeds to delete them from the records file.
*/

class Delete 
{
   /**
   "deleteGame" searches for data and deletes it based on the input.
   @param fileName The name of the text file to take the data from.
   @param data The data set to search for the Delete class target.
   @param deleteInput The specific data category to look for assigned to a numerical value.
               0 is Name
               1 is FileName
               2 is MethodName
               3 is Date Created
               4 is Rating
               5 is Publisher
   */
   public void deleteGame(String fileName, String data[][], int item, String deleteInput)
   {
      DataInput d = new DataInputStream(System.in);
      String input;
      input = deleteInput;
      if(input != null)
      {
         boolean found = false;
         for(int i = 0; i < data.length; i++)//Search for record
         {
            if(data[i][item].equals(input))
            {
               System.out.println("Record found!");
               found = true;
               for(int k = 0; k < 6; k++)
               {
                  System.out.print(data[i][k] + "\t\t"); //output entire record
                  data[i][k]="";//erase record items
               }
               System.out.println("");
            }//end if
         }//end loop
         if(!found)
         {
            System.out.println("No record found!");
         }  
         Write ur = new Write();  
         ur.writeGame(fileName, data);
      } 
   }
}