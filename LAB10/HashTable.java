package LAB10;

class HashTable<T> {
    private Entry[] entries;

    public HashTable(int size) {
        entries = new Entry[size];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new Entry();
            entries[i].setDataObject(null);
            entries[i].setStatus("E");
        }
    }

    public boolean insert(T dataObject) {
        // use find to check if data is already available
        if (find(dataObject) != -1) {
            System.out.println(dataObject + " is duplicate element. Not inserted.");
            return false;
        }
        // else, following similar procedure to find by using hashValue and nextSlot
        int hashValue = 0;
        // if dataObject is Integer, we'll assign it immediately to hashValue
        if (dataObject instanceof Number)
            hashValue = (int) dataObject;

            // if dataObject is String, we'll add each char value to hashValue
        else if (dataObject instanceof String) {
            for (int i = 0; i < ((String) dataObject).length(); i++) {
                hashValue += ((String) dataObject).charAt(i);
            }
        }
        // then, we'll find the next appropriate index/slot
        int nextSlot = findNextAvailableSlot(hashValue);
        // if slot is not  occupied, return set status to 'O' and insert the value to the entry
        if (entries[nextSlot].getStatus().equals("E") || entries[nextSlot].getStatus().equals("D")) {
            entries[nextSlot].setStatus("O");
            entries[nextSlot].setDataObject(dataObject);
            return true;
        }
        // if the slot is occupied, traverse through the table by incrementing each time by one
        else {
            for (int i = 1; i < entries.length; i++) {
                nextSlot = findNextAvailableSlot(hashValue + i);
                if (entries[nextSlot].getStatus().equals("E") || entries[nextSlot].getStatus().equals("D")) {
                    entries[nextSlot].setStatus("O");
                    entries[nextSlot].setDataObject(dataObject);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(T dataObject) {
        int nextSlot = find(dataObject);
        // if dataObject is found
        if (nextSlot != -1) {
            entries[nextSlot].setStatus("D");
            System.out.println(dataObject + " successfully deleted.");
            return true;
        }
        System.out.println(dataObject + " not deleted because it is not in the table.");
        return false;
    }

    public int find(T dataObject) {
        int hashValue = 0;

        // if dataObject is Integer, we'll assign it immediately to hashValue
        if (dataObject instanceof Number)
            hashValue = (int) dataObject;

            // if dataObject is String, we'll add each char value to hashValue
        else if (dataObject instanceof String) {
            for (int i = 0; i < ((String) dataObject).length(); i++) {
                hashValue += ((String) dataObject).charAt(i);
            }
        }
        // then, we'll find the next appropriate index/slot
        int nextSlot = findNextAvailableSlot(hashValue);

        // if slot is occupied, return index
        if (entries[nextSlot].getStatus().equals("O") && entries[nextSlot].getDataObject().equals(dataObject)) {
            return nextSlot;
        }
        // if the slot is not occupied, traverse through the table by incrementing each time by one
        else {
            for (int i = 1; i < entries.length; i++) {
                nextSlot = findNextAvailableSlot(hashValue + i);
                if (entries[nextSlot].getStatus().equals("O") && entries[nextSlot].getDataObject().equals(dataObject)) {
                    return nextSlot;
                }
            }
        }
        return -1;
    }

    public int findNextAvailableSlot(int currentSlot) {
        return currentSlot % entries.length;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < entries.length; i++)
            output += i + ": " + entries[i] + "\n";

        return output;
    }
}
