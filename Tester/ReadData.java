import java.io.*;
class ReadData {//read data from external file using readFile() method
   public String[] readFile(String fname, int max){//fname = "records.txt"
   String data[] = new String[max];
   for(int k = 0; k < max; k++)
      data[k] = "";
   int i = 0;
   try{
      DataInput in = new DataInputStream(new FileInputStream(fname));
      String txt = in.readLine();
      while (txt != null){
         data[i++] = txt;//store record in array, data and increment i
         txt = in.readLine();
      }//end while
   }catch (Exception e){};
   return data;
   }//end read file
}// end read data
