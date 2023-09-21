// id: 202154790 , sec: 54

public class DLL_Driver {
    public static void main(String[] args) {
        DLL<String> test = new DLL<String>();

        for(int i = 0; i < 7; i++)
            test.addToTail("a" + i);

        System.out.println("List1:");
        test.printAll();
        System.out.println("Print List1 in reverse: ");

        test.printReverse();


        DLL<String> test2 = new DLL<String>();


        for(int i = 4; i < 7; i++)
            test2.addToTail("a" + i);

        System.out.println("List1:");
        test.printAll();
        System.out.println("List2: ");
        test2.printAll();
        System.out.println("insert list 2 on list 1:");
        test.insertAlternate(test2);

        System.out.println("Delete 7th element of List each time: ");
        while(!test.isEmpty()) {
            test.delete7();
            test.printAll();
        }
        System.out.println("List is Empty");
    }
}