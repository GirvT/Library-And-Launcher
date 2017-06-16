//Author: Girvan Tse
//Date : 08/06/17

import java.io.*;

/**
@author Girvan Tse 
Takes the given data set and updates any changes made
*/

class Write
{
   /**
   Takes the given data set and applies any changes to the data set
   @param fileName The name of the text file to be updated
   @param data The changed data set to implement into the file
   */
   public static void writeGame(String fileName, String data[][])
   {//records.txt
      try{
            File in = new File(fileName);
            FileOutputStream myout = new FileOutputStream(in);
            DataOutputStream myData = new DataOutputStream(myout);
            for(int i =0; i < data.length; i++){// update records
               String txt = "";
               if(data[i][0].equals(""))continue;//pmit the record
               for(int j = 0; j < 6; j++)
                  txt += data[i][j] + "#";
               myData.writeBytes(txt + "\r");
            }
            myout.close();
         }catch(Exception e){}
   }
}