import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if (n <= 0)  // The smallest list we can make
        {
            return tempList;
        }
        else        // All other size lists are created here
        {
            tempList.addAll(makeList(n-1));
            tempList.add(n);
        }
        return tempList;
    }
    
    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }
}
