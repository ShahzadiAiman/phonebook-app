import java.io.*;
import java.util.*;

public class PhonebookEntry {
    private Name name;
    private PhoneNumber phoneNumber;


    public PhonebookEntry(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return this.name;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public String call() {
        String call;
        if (phoneNumber.isTollFree()) {
            call = "Dialing (toll-free) " + toString();
        } else {
            call = "Dialing " + toString();
        }
        return call;
    }

    public String toString() {
        return name + ": " + phoneNumber;
    }

    public boolean equals(PhonebookEntry other) {
        return name.equals(other.name);
    }

    public static PhonebookEntry read(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        Name name = Name.read(scanner);
        PhoneNumber phoneNumber = PhoneNumber.read(scanner);

        return new PhonebookEntry(name, phoneNumber);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("phonebook.text"));

        int count = 0;
        PhonebookEntry previousEntry = null;
        PhonebookEntry phoneBookEntry = read(scanner);

        while (phoneBookEntry != null) {
            if (previousEntry != null && phoneBookEntry.getName().equals(previousEntry.getName()) && phoneBookEntry.getPhoneNumber().equals(previousEntry.getPhoneNumber())) {
                System.out.println("Duplicate phone book entry \"" + phoneBookEntry.toString() + "\" discovered");

            } else {
                if (previousEntry != null && phoneBookEntry.getName().equals(previousEntry.getName())) {
                    System.out.println("Warning duplicate name encountered \"" + phoneBookEntry.toString() + "\" discovered");
                }
                System.out.println("phone book entry: " + phoneBookEntry.toString());
                System.out.println(phoneBookEntry.call());
                System.out.println();
            }

            count++;
            previousEntry = phoneBookEntry;
            phoneBookEntry = read(scanner);
        }
        System.out.println("---");
        System.out.println(count + " phonebook entries processed.");

    }
}