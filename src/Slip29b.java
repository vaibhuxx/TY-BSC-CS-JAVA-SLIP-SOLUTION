import java.util.LinkedList;

 

public class Slip29b {

    public static void main(String[] args) {

        // Create a LinkedList of integer objects

        LinkedList<Integer> list = new LinkedList<Integer>();

       

        // Add elements at the first position

        list.addFirst(10);

        list.addFirst(20);

        list.addFirst(30);

        System.out.println("LinkedList after adding elements at the first position: " + list);

       

        // Delete the last element

        list.removeLast();

        System.out.println("LinkedList after deleting the last element: " + list);

       

        // Display the size of the LinkedList

        System.out.println("Size of the LinkedList: " + list.size());

    }

}

 