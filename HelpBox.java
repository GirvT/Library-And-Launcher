import javax.swing.*;

public class HelpBox
{
   public static void helpbox()
  {
   EvenMoreHelpBoxes help2 = new EvenMoreHelpBoxes();
   String [] options = {"Add", "Delete", "Launch", "Refresh", "Sort", "Search"};
   String input = (String) JOptionPane.showInputDialog(null, "What do you need help with?","Help", JOptionPane.QUESTION_MESSAGE, null, 
                                                                       
                                                                       
   options, // Array of choices
   options[0]); // Initial choice
   if (input == "Add")
     {
     help2.moreHelpBoxes(1);
     }
   else if (input == "Delete")
     {
     help2.moreHelpBoxes(2);
     }
   else if (input == "Launch")
     {
     help2.moreHelpBoxes(3);
     }
   else if (input == "Refresh")
     {
     help2.moreHelpBoxes(4);
     }
   else if (input == "Sort")
     {
     help2.moreHelpBoxes(5);
     }       
   else if (input == "Search")
     {
     help2.moreHelpBoxes(6);
     }               
  }
}

   