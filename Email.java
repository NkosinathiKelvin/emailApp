import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }


    // Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + "\nDepartment Codes:\n    1 - Sales\n    2 - Development\n    3 - Accounting\n    0 - none\nEnter department code: ");
        Scanner input = new Scanner(System.in);
        int departmentChoice = input.nextInt();

        if (departmentChoice == 1){
            return "sales";
        }
        else if (departmentChoice == 2) {
            return "development";
        } else if (departmentChoice == 3) {
            return "accounting";
        }
        else {
            return "";
        }
    }


    // Generate a random password
    // =========== fix to generate random characters from passwordSet ==============
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#@$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int randomNumber = (int) Math.random() * passwordSet.length();
            password[i] = passwordSet.charAt(randomNumber);
        }
        return new String(password);
    }


    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }


    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }


    // Change the password
    public void changePassword(String password){
        this.password = password;
    }


    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }


    public String getAlternateEmail(){
        return alternateEmail;
    }


    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
