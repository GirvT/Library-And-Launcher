public class SelectionSort
{   
   public static void main (String[] args) throws InterruptedException
   {  
       for(int i=0; i<a.length-1;i++)
       {
          int a[] = new int[6];
          a[0] = 15;
          a[1] = 32;
          a[2] = 10;
          a[3] = 99;
          a[4] = 2;
          a[5] = 7;
          for(int i=0; i<a.length-1;i++)
          {
             int index = i;
             for(int j = i + 1 ; j<a.length ; j++)
             {
                if(a[j] < a[index])
                {
                    index = j;
                }
                int small = a[index];
                a[index] = a[i];
                a[i]=small;
             }
         }
      }
      System.out.println(Arrays.toString(a));
   }
}