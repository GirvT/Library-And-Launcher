//Filename: SearchInput.java
//Author: Girvan Tse & Manish Suresh
//Date : 05/03/17

import java.io.*;

/**
Takes an input in the form which the Search class can read
@author Girvan Tse & Manish Suresh
*/

class Search //prepares keyboard to recieve data
{
   /**
   Takes the data and puts it into a form that the Search class can read
   @param fileName The name of the file to take the data from
   @param data The data set to search for the Search class target
   @param item The specific data category to look for assigned to a numerical value
               0 is Name
               1 is ID
               2 is Homeform
               3 is Date
               4 is Time
               5 is Period
   */
   public void searchGame(String fileName, String data[][], int item)
   {
      DataInput d = new DataInputStream(System.in);
      String input;
      Search s = new Search();
      System.out.println("Who would you like to search?");
      try
      {
         input = d.readLine();
         if(input != null)
         {
            System.out.println("Searching...\n");
            boolean found = false;
            for(int i = 0; i < data.length; i++)//Search for record
            {
               if(data[i][item].equals(input))
               {
                  found = true;
                  for(int k = 0; k < 6; k++)
                  {
                     System.out.print(data[i][k] + "\t\t"); //output entire record
                     System.out.println();
                  }
               }//end if
            }//end loop
            if(!found)
            {
               System.out.println("No record found!");
            }  
         }
      }
      catch(IOException ignored)
      {
      }
   }//end keyInput
}//end searchInput