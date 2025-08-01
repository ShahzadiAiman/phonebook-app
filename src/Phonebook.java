import java.util.*;
import java.io.*;

public class Phonebook {
    private static final int DEFAULTCAPACITY = 100;
    private PhonebookEntry[] phonebookEntries = new PhonebookEntry[DEFAULTCAPACITY];
    private static int count = 0;


    public Phonebook( String fileName, int initialCapacity ) throws Exception {
        this.phonebookEntries = new PhonebookEntry[initialCapacity];
        this.count =0;
        read(fileName);
    }
    public Phonebook(String fileName) throws Exception {
        this(fileName, DEFAULTCAPACITY);
    }


    public void read(String filename) throws Exception {
        Scanner fileScanner = new Scanner(new File(filename));

        File file = new File(filename);
        if (!file.exists()) {
            throw new IOException("phonebook.text (No such file or directory)");
        }

        while (fileScanner.hasNext()) {
            if (count >= DEFAULTCAPACITY) {
                throw new Exception("*** Exception *** Phonebook capacity exceeded - increase size of underlying array");
            }
            phonebookEntries[count] = PhonebookEntry.read(fileScanner);
            count++;
        }
        fileScanner.close();
    }


    public PhonebookEntry lookup (Name name) {
        for (int i = 0; i < count; i++) {
            if (phonebookEntries[i].getName().equals(name)){
                return phonebookEntries[i];
            }
        }
        return null;
    }

    public PhonebookEntry reverseLookup(PhoneNumber phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (phonebookEntries[i].getPhoneNumber().equals(phoneNumber)) {
                return phonebookEntries[i];
            }
        }
        return null;
    }
}