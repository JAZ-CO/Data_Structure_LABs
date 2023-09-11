// Name, ID, Section Number, Date
// Jalal Zainaddin, s202154790, 54, 09/03/2023

import java.util.LinkedList;

// Driver class:
class LinkedListDriver {
    public static void main(String[] args) {
        // creating a Linked List and add element as cities
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Madinah");
        stringList.add("Dammam");
        stringList.add("Riyadh");
        stringList.add("Dhahraan");
        System.out.println("List: " + stringList);

        int index = stringList.indexOf("Riyadh");
        if(index == -1)
            System.out.println("Riyadh is not in the list");
        else{
            stringList.add(index + 1, "Jubail"); // insert Jubail after Riyadh
            stringList.addFirst("Najraan");   // insert Najraan at the beginning
        }

        System.out.println("List: " + stringList);

        index = stringList.indexOf("Dhahraan");
        if(index == -1)
            System.out.println("Dhahraan is not in the list");
        else
            stringList.set(index, "Abha");   // replace Dhahran with Abha

        String removedString = stringList. removeFirst();
        System.out.println("Removed Element: " + removedString);
        stringList.addFirst("Taif");
        System.out.println("Updated list: " + stringList);

        // Add code that will insert "Tabouk" before "Dammam", display error message if
        // "Dammam" is not in list or if the list is empty. Your code must work for any
        // two strings str1 and str2.

        // created two variables to make it more readable
        // the city
        String elem = "Dammam";
        // and the new city which will go before the previous city "Dammam"
        String elemBefore = "Tabuk";

        // using Try/Catch in order to handle exceptions when possible
        try {
            if (stringList.contains(elem)) {
                stringList.add(stringList.indexOf(elem) , elemBefore);
                System.out.println("List after adding Tabouk: "+ stringList);
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        // Add code that will insert "AlKhafj" before the last node, your code must work
        // for any non-empty list. Display an error message if the list is empty.

        // using Try/Catch in order to handle exceptions when possible
        try {
            if (stringList.size() >0) {
                stringList.add(stringList.indexOf(stringList.getLast()) , "Alkhafj");
                System.out.println("List after adding AlKhafj: "+ stringList);
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception exception){
            System.out.println(exception);
        }

    }
}
// task 3: test class
public class test {
    public static void main(String[] args) {
        // creating a list of integers and an array in order to add it to the list
        SLL<Integer> myList = new SLL<>();
        Integer[] nums = {7, 5, 3, 50, 7, 9 };

        for (int i = 0; i < nums.length; i++) {
            myList.addToTail(nums[i]);
        }

        // 0- Original array
        System.out.println("Original Integer array: " + myList);

        // 1- insert before:
        myList.insertBefore(4,20);
        System.out.println("After inserting 20 before index 4: " + myList);

        // 2- delete:
        System.out.println("Element deleted from index 4: " + myList.delete(4));
        System.out.println("After deleting element from index 4: " + myList);

        // 3- Insert after two occurrences
        myList.insertAfterSecondOccurrence(30,7);
        System.out.println("After inserting 30 after the second occurence of 7: " + myList);

    }
}
