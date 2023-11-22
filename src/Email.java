import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 700;
    private int defaultpassWordLength = 10;
    private String alternateEmail;
    private String companySuffix = "ludwig.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        // Call a method asking for the department - return department
        this.department = setDepartment();


        // Call a method that returns a random password
        this.password = randomPassword(defaultpassWordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New staff: " + firstName + ". DEPARTMENT CODES:\n1 for Admin\n2 for MIS\n3 for HR\n4 for EnvironmentalHealth\n5 for Urban\n6 for Finance\n0 for None\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        switch(deptChoice) {
            case 1:
                return "Admin";
            case 2:
                return "MIS";
            case 3:
                return "HR";
            case 4:
                return "EnvironmentalHealth";
            case 5:
                return "Urban";
            case 6:
                return "Finance";
            default:
                return "None";
        }

    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }
    public String showInfo() {
        return " DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";

    }

}
