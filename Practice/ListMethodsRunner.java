import java.util.ArrayList;

public class ListMethodsRunner
{
   public static void main(String[] args)
   {
      ArrayList<Integer> list = ListMethods.makeList(10);
      if (list.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         System.out.println(list);
      }
      System.out.println(ListMethodsRunner.reverseList(list));
   }
   
   public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
   {
       ArrayList<Integer> list = ListMethods.deepClone(tList);
       if (list.size()<=1)
       {
          return list;
       }
       else
       {
          int index = list.get(0);
          list.remove(0);
          list = reverseList(list);
          list.add(index);
          return list;
       }
       
   }
   
}