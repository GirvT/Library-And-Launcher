//Author: Girvan Tse 
//Date : 08/06/17

/**
Takes the given data set and sorts it using a sorting algorthim
@author Girvan Tse 
*/

class Sort
{
   /**
   Takes the given data set and sorts it using a sorting algorthim
   @param data The data set to organize
   @param item The specific data category to organized assigned to a numerical value
               0 is Name
               1 is FileName
               2 is MethodName
               3 is Date Created
               4 is Rating
               5 is Publisher
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
            