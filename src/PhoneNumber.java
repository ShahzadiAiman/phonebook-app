import java.io.*;
import java.util.*;

class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getAreaCode (){
        return number.substring(1,4);
    }

    public String getExchange (){
        return number.substring(5,8);
    }

    public String getLineNumber (){
        return number.substring(9,13);
    }

    public boolean isTollFree (){
        return getAreaCode().charAt(0) == '8';
    }

    public String toString (){
        return number;
    }

    public boolean equals (PhoneNumber other){
        return number.equals(other.number);
    }

    public static PhoneNumber read (Scanner scanner){
        if (!scanner.hasNext()){
            return null;
        }
        String number = scanner.next();
        return new PhoneNumber (number);
    }

    public static void main (String [] args) throws IOException{
        Scanner scanner = new Scanner (new File ("numbers.text"));

        int count = 0;
        PhoneNumber previousNumber = null;
        PhoneNumber number = read(scanner);

        while (number !=null){
            if (previousNumber != null && number.equals(previousNumber)){
                System.out.println("Duplicate phone number \"" + number.toString() + "\" discovered");
            } else{
                System.out.println("phone number: " + number.toString());
                System.out.println("area code: " + number.getAreaCode());
                System.out.println("exchange: " + number.getExchange());
                System.out.println("line number: " + number.getLineNumber());
                System.out.println("is toll free: " + number.isTollFree());
                System.out.println();

            }
            count++;
            previousNumber = number;
            number = read(scanner);
        }
        System.out.println("---");
        System.out.println(count + " phone numbers processed.");
    }
}