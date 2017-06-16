//Author: Girvan Tse
//Date : 08/06/17

import java.util.StringTokenizer;

/**
@author Girvan Tse
Records converts the data from a text file into a 2D array
*/

class Records 
{ 
   /**
   getRecords take in data and converts it into a 2D array based on the position of # in the text file
   @parma data is the data set that needs to be converted 
   */
   public String[][] getRecords(String data[])
   {
      int n = data.length;
      String records[][] = new String[n][6];//Store records in 2-dimensional array with columns of 6
      for(int p = 0; p < n; p++) // intializes all records
         for(int q = 0; q < 6; q++)
            records[p][q] = "";
      for(int line = 0; line < n; line++)
      {
         if(data[line].equals(""))break;
         StringTokenizer st = new StringTokenizer(data[line],"#");
         int i = 0;
         while(st.hasMoreTokens() && i < 6)
         {
            records[line][i] = st.nextToken();//Store each item of the record
            i++;
         }// end while
      }// end for
      return records;    //return the 2-dmensional array records
   }// end getrecords 
}// end records
            