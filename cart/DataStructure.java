package cart ;
import java.util.*;


public class DataStructure {
    public static void main(String args[]){
        System.out.println("Data structure ");
        List<Integer> intList = new LinkedList<Integer>();         //initialising the linklist 

        intList.add(Integer.parseInt("12"));                    //
        intList.add(10);
        intList.add(20);
        intList.add(0,56);

        System.out.println(intList);

        for(int i =0; i< intList.size(); i++){
            System.out.printf("idx: %d\n", i);
            System.out.printf("Val: %d\n", intList.get(i));
        }
    }
}