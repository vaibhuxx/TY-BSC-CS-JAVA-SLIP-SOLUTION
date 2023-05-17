import java.util.*;

public class Slip21a

{

 public static void main(String[] args) {

 LinkedList<String>myList = new LinkedList<String>();

 myList.add("Red");

 myList.add("Green");

 myList.add("Blue");

 myList.add("Brown");

 myList.add("Pink");

 myList.add("Purple");

 ListIterator<String>list_it = myList.listIterator(0);

 System.out.println("Elements in the LinkedList:");

 while(list_it.hasNext()){

 System.out.print(list_it.next() + " ");}

 }

}