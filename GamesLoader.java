//Author: Girvan Tse
//Date : 05/03/17

import javax.swing.*;

/**
@author Girvan Tse
GamesLoader loads a game base on its filename/classname and method name during runtime.
*/
public class GamesLoader extends JavaClassLoader {

   int x;
   /**
   "load" takes the inputted game and base on the data given in records will attempt to do the matching
   class name and file name, if it exists.
   @param gameInput the name of the game, to be checked if it exists in the records.
   @param info the records file to check filename and methodname for.
   */
   public void load(String gameInput, String info[][])
   { 
      for ( x = 0; x < info.length; x++)
      {
         //Check if class name exists
         if ( gameInput.toLowerCase().contains(info[x][1].toLowerCase()))
         {
            //Check if method name exists
            if ( gameInput.toLowerCase().contains(info[x][2].toLowerCase())) 
            {
               //Main loader function
               JavaClassLoader javaClassLoader = new JavaClassLoader();
   		      javaClassLoader.invokeClassMethod(info[x][1], info[x][2]);
               break;
            } 
         }
      } 
      
      //Check if class name dosent exist
      if ( gameInput.toLowerCase().contains(info[x][1].toLowerCase()))
      {  
         //Check if method name dosent exist
         if ( gameInput.toLowerCase().contains(info[x][2].toLowerCase())) 
         {
            //do nothing if both exist
         } 
         else
         {
            //error message if not found (both don't exist)
         JOptionPane.showMessageDialog(null, "Game not found");
         }
      } 
   }	
}