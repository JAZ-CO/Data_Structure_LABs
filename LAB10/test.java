package LAB10;

public class test {
    public static void main(String[] args) {
        HashTable<Integer> table = new HashTable<>(13);
        table.insert((18));table.insert((26));table.insert((18));table.insert((35));table.insert(9); table.insert(26);

        System.out.println("After inserting 18, 26, 35, and 9 the hashtable is: ");
        System.out.println(table);

        if (table.find(15) !=-1)
            System.out.println(15+" found at index "+table.find(15)+".");
        else
            System.out.println(15+" not found.");
        if (table.find(40) !=-1)
            System.out.println(40+" found at index "+table.find(40)+".");
        else
            System.out.println(40+" not found.");

        table.delete(35);table.insert(9); table.delete(40);

        if (table.find(9) !=-1)
            System.out.println(9+" found at index "+table.find(9)+".");
        else
            System.out.println(9+" not found.");

        table.insert(64); table.insert(47);
        System.out.println("After deleting 35 and inserting 64 and 47 the hashtable is: ");
        System.out.println(table);

        table.insert(77); table.insert(21); table.delete(26); table.insert(39);

        if (table.find(35) !=-1)
            System.out.println(35+" found at index "+table.find(35)+".");
        else
            System.out.println(35+" not found.");

        System.out.println("After inserting 77, 21, deleting 26 and inserting 39 the hashtable is: ");
        System.out.println(table);
    }
}
