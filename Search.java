//Author: Girvan Tse
//Date : 08/06/17

import java.io.*;

/**
@author Girvan Tse
Takes an input in the form which the Search class can read
*/

class Search //prepares keyboard to recieve data
{
   String ss;
   /**
   "searchGame" reads the input and returns the data with the same specified data 
   @param fileName The name of the file to take the data from
   @param data The data set to search for the Search class target
   @param item The specific data category to look for assigned to a numerical value
               0 is Name
               1 is FileName
               2 is MethodName
               3 is Date Created
               4 is Rating
               5 is Publisher
   */
public String searchGame(String fileName, String data[][], int item, String input)
   {
      DataInput d = new DataInputStream(System.in);
      StringBuilder sb = new StringBuilder();
      if(input != null)
      {
         boolean found = false;
         for(int i = 0; i < data.length; i++)//Search for record
         {
            if(data[i][item].equals(input))
            {
               found = true;
               for(int k = 0; k < 6; k++)
               {
                  sb.append(data[i][k] + "\t"); //output entire record
               }
               sb.append("\n");
            }//end if
         }//end loop
         if(!found)
         {
         } 
      }
      ss = sb.toString();
      return ss;
   }//end keyInput
}//end searchInput