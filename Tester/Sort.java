//Filename: Sorter.java
//Author: Girvan Tse & Manish Suresh
//Date : 05/03/17

/**
Takes the given data set and sorts it using a sorting algorthim
@author Girvan Tse & Manish Suresh
*/

class Sort
{
   /**
   Takes the given data set and sorts it using a sorting algorthim
   @param data The data set to organize
   @param item The specific data category to organized assigned to a numerical value
               0 is Name
               1 is ID
               2 is Homeform
               3 is Date
               4 is Time
               5 is Period
   */
   public static String[][] sortGame(String data[][], int item)
   {//input records; item = name etc
      String temp;
      int len = data.length - 1;
      for(int i = len; i > 1; i--)
         for(int j = 0; j < i; j++)
            if(data[j][item].compareTo(data[j+1][item]) > 0)
            {
            for(int k = 0; k < 6; k++)
               swap(data,j,k);//swapping all 6 items
            }// end if
      return data;// return sorted data
   }// end sort
   
   static void swap(String data[][], int index, int item) 
   {
      String temp;
      temp = data[index][item];
      data[index][item] = data[index + 1][item];
      data[index + 1][item] = temp;
   }//end swap
}// end sorter
            