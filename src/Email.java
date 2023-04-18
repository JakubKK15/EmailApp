import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private final int defaultPasswordLength = 10;
    private final String companySuffix = "abcompany.com";
    private final String email;
    private String password;
    private int mailboxCapacity = 500;
    private String department;
    private String altEmail;

    // Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        this.password = setRandomPassword(defaultPasswordLength);
        System.out.println("Password: " + password);

        this.email = this.firstName.toLowerCase() + "." +
                this.lastName.toLowerCase() + "@" +
                this.department.toLowerCase() + "." +
                this.companySuffix;
    }

    // Ask for the department

    private String setDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Worker: " + firstName);
        System.out.print("""
                DEPARTMENT CODES
                1) Sales
                2) Development
                3) Accounting
                0) None
                Choice:\s""");
        int depChoice = scanner.nextInt();
        if (depChoice == 1) {
            department = "Sales";
        } else if (depChoice == 2) {
            department = "Development";
        } else if (depChoice == 3) {
            department = "Accounting";
        } else if (depChoice == 0) {
            department = "";
        } else {
            System.out.println("Enter a correct number.");
            setDepartment();
        }
        scanner.close();
        return department;
    }

    // Generate a random password
    private String setRandomPassword(int length) {
        String passwordChars = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordChars.length());
            password[i] = passwordChars.charAt(rand);
        }
        return new String(password);
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // Set the alternate email

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    @Override
    public String toString() {
        return "Info{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mailboxCapacity=" + mailboxCapacity + "mb" +
                ", altEmail='" + altEmail + '\'' +
                '}';
    }
}