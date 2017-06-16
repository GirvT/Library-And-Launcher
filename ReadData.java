//Author: Girvan Tse & Manish Suresh
//Date : 08/06/17

import java.io.*;

/**
@author Girvan Tse
@author Manish Suresh
Read class takes the data from a text file
*/

class ReadData
{
   /**
   "readFile" reads data from a file up to a specified maximum
   @param fileName The name of the text file which the data is pulled from
   @param max The maximum number of data to read in the file
   */
   public String[] readFile(String fileName, int max)
   {
      String data[] = new String[max];
      for(int k = 0; k < max; k++)
      {
         data[k] = "";
      }
      int i = 0;
      try
      {
         DataInput in = new DataInputStream(new FileInputStream(fileName));
         String txt = in.readLine();
         while (txt != null)
         {
            data[i++] = txt;//store record in array, data and increment i
            txt = in.readLine();
         }//end while
      }
      catch (Exception e){};
      return data;
   }//end read file
}// end read data