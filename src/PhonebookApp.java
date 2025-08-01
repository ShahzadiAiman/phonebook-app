import java.util.*;
import java.io.*;

public class PhonebookApp {
    public static void main(String[] args) throws IOException{
        Scanner keyboard = new Scanner(System.in);

        int lookupCount = 0;
        int reverseLookupCount = 0;
        String input;

        try {
            Phonebook phonebook = new Phonebook("phonebook.text");
            do {
                System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
                input = keyboard.next();

                if (input.charAt(0) == 'l') {
                    lookupCount++;
                    System.out.print("last name? ");
                    String lName = keyboard.next();
                    System.out.print("first name? ");
                    String fName = keyboard.next();

                    Name name = new Name(lName, fName);
                    PhonebookEntry entry = phonebook.lookup(name);

                    if (entry != null) {
                        System.out.println(name.getFormal() + "'s phone number is " + entry.getPhoneNumber());
                    } else {
                        System.out.println("-- Name not found");
                    }
                    System.out.println();

                } else if (input.charAt(0) == 'r') {
                    reverseLookupCount++;
                    System.out.print("phone number (nnn-nnn-nnnn)? ");
                    String num = keyboard.next();

                    PhoneNumber phoneNumber = new PhoneNumber(num);
                    PhonebookEntry entry = phonebook.reverseLookup(phoneNumber);

                    if (entry != null) {
                        System.out.println(num + " belongs to " + entry.getName().getFormal());
                    } else {
                        System.out.println("-- Phone number not found");
                    }
                    System.out.println();
                }

            } while (input.charAt(0) != 'q');
            System.out.println();
            System.out.println(lookupCount + " lookups performed");
            System.out.println(reverseLookupCount + " reverse lookups performed");
            System.out.println();

        }catch (FileNotFoundException e){
            System.out.println("Error: phonebook.text file not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
