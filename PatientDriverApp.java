/*
 * Class: CMSC203
 * Instructor: Khandan Monshi
 * Description: Assignment 2: write a program that reads patient data, validates it, and outputs it, all while using multiple classes and methods
 * Due: 09/30/2026
 * Platform/compiler: Win11 26H2 build 26300.8935 / openjdk 21.0.1 (Microsoft provided)
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Michael Jarman
 */

import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PatientDriverApp {

    // Runs test harness when set as true. This will not run the default method.
    final private static boolean testRun = false;

    /**
     * main is used for data acquisition and object creation
     * @param args none
     */
    public static void main (String[] args) {
        /**
         * Test harness check. I wanted to check every method without writing JUnit tests.
         * There's not a lot to check, set testRun to true to run this.
         */
        if (!testRun) {
            var input = new Scanner(System.in);
            Patient p = new Patient();
            p = inputPatient(input);

            // display patient info with new object
            displayPatient(p);

            // create all 3 procedures
            Procedure p1 = createProcedure1();
            Procedure p2 = createProcedure2();
            Procedure p3 = createProcedure3();

            // display newly created procedures
            displayProcedureTable(p1, p2, p3);
        } else {
            runTests();
        }
    }

    /**
     * collects all patient data
     * @param input keyboard input - type scanner
     * @return filled patient object - type patient
     */
    private static Patient inputPatient (Scanner input) {
        // local strings
        String firstName;
        String middleName;
        String lastName;
        String streetAddress;
        String cityName;
        String stateName;
        String zipCode;
        String phoneNumber;
        String emergencyContactName;
        String emergencyContactPhoneNumber;
        Patient p = new Patient();

        // collect name info
        System.out.print("Enter first name: ");
        firstName = input.nextLine();
        System.out.print("Enter middle name: ");
        middleName = input.nextLine();
        System.out.print("Enter last name: ");
        lastName = input.nextLine();

        // collect biographic info
        System.out.print("Enter street address: ");
        streetAddress = input.nextLine();
        System.out.print("Enter city: ");
        cityName = input.nextLine();
        System.out.print("Enter state: ");
        stateName = input.nextLine();
        System.out.print("Enter zip: ");
        zipCode = input.nextLine();

        System.out.print("Enter phone number (###-###-####): ");
        phoneNumber = input.nextLine();

        System.out.print("Enter emergency contact name: ");
        emergencyContactName = input.nextLine();
        System.out.print("Enter emergency contact phone (###-###-####): ");
        emergencyContactPhoneNumber = input.nextLine();

        // return patient object
        return p = new Patient(firstName, middleName, lastName,
                streetAddress, cityName, stateName, zipCode,
                phoneNumber, emergencyContactName, emergencyContactPhoneNumber);
    }

    /**
     * Create first procedure with data:
     * - Procedure: Consultation
     * - Date: 09/22/2024
     * - Practitioner: Dr. Carson
     * - Cost: $225.73
     * @return new procedure - type procedure
     */
    private static Procedure createProcedure1 () {
        Procedure p = new Procedure();
        p.setProcedureName("Consultation");
        p.setProcedureCharge(225.73);
        p.setProcedurePractitioner("Dr. Carson");
        p.setProcedureDate("09/22/2024");
        return p;
    }

    /**
     * Create second procedure with data:
     * - Procedure: CT Scan
     * - Date: 05/14/2025
     * - Practitioner: Dr. Nick
     * - Cost: $753.33
     * @return new procedure - type procedure
     */
    private static Procedure createProcedure2 () {
        Procedure p = new Procedure("CT scan", "05/14/2025");
        p.setProcedurePractitioner("Dr. Nick");
        p.setProcedureCharge(753.33);
        return p;
    }

    /**
     * Create third procedure with data:
     * - Procedure: Open Heart Surgery
     * - Date: 09/10/2026
     * - Practitioner: Dr. Jimothy
     * - Cost: $5545724.22
     * @return new procedure - type procedure
     */
    private static Procedure createProcedure3 () {
        Procedure p = new Procedure ("Open Heart Surgery", "09/10/2026", "Dr. Jimothy", 5545724.22);
        return p;
    }

    /**
     * Display patient information with formatting. calls getContactSummary to show info
     * @param patient patient object to display contant summary for - type patient
     */
    private static void displayPatient (Patient patient) {
        System.out.print("\nPatient information\n-------------------\n");
        System.out.print(patient.getContactSummary());
    }

    /**
     * displays procedure information in tabulated form
     * @param procedure procedure to display - type procedure
     */
    private static void displayProcedure (Procedure procedure) {
        System.out.printf("%-22s %-12s %-18s %15s %-5s%n",
                procedure.getProcedureName(),
                procedure.getProcedureDate(),
                procedure.getProcedurePractitioner(),
                procedure.getFormattedCharge(),
                procedure.getChargeCategory());
    }

    /**
     * display procedure table with tabulated formatting. calls displaySummary to show procedure info.
     * @param p1 first procedure - type procedure
     * @param p2 second procedure - type procedure
     * @param p3 third procedure - type procedure
     */
    private static void displayProcedureTable (Procedure p1, Procedure p2, Procedure p3) {
        System.out.print("\n\n");
        System.out.printf("%-22s %-12s %-18s %15s %-12s", "Procedure", "Date", "Practitioner", "Charge", "Category");
        System.out.print("\n------------------------------------------------------------------------\n");
        displaySummary(p1, p2, p3);
    }

    /**
     * calculate total procedure cost
     * @param p1 first procedure - type procedure
     * @param p2 second procedure - type procedure
     * @param p3 third procedure - type procedure
     * @return total cost of all procedures - type double
     */
    private static double calculateTotalCharges (Procedure p1, Procedure p2, Procedure p3) {
        return (p1.getProcedureCharge() + p2.getProcedureCharge() + p3.getProcedureCharge());
    }

    /**
     * calculate average charge of three
     * @param p1 first procedure - type procedure
     * @param p2 second procedure - type procedure
     * @param p3 third procedure - type procedure
     * @return average cost of all procedures - type double
     */
    private static double calculateAverageCharge (Procedure p1, Procedure p2, Procedure p3) {
        return calculateTotalCharges(p1, p2, p3) / 3;
    }

    /**
     * find highest charge given 3 procedures
     * @param p1 first procedure - type procedure
     * @param p2 second procedure - type procedure
     * @param p3 third procedure - type procedure
     * @return highest cost procedure - type procedure
     */
    private static Procedure findHighestChargeProcedure (Procedure p1, Procedure p2, Procedure p3) {
        double p1Charge = p1.getProcedureCharge();
        double p2Charge = p2.getProcedureCharge();
        double p3Charge = p3.getProcedureCharge();
        if (p1Charge >= p2Charge && p1Charge >= p3Charge) {
            return p1;
        } else if (p2Charge >= p1Charge && p2Charge >= p3Charge) {
            return p2;
        } else {
            return p3;
        }
    }

    /**
     * counts expensive procedures using isExpensiveProcedure method
     * @param p1 first procedure - type procedure
     * @param p2 second procedure - type procedure
     * @param p3 third procedure - type procedure
     * @return number of procedures above defined value - type int
     */
    private static int countExpensiveProcedures (Procedure p1, Procedure p2, Procedure p3) {
        int sum = 0;
        if (p1.isExpensiveProcedure())
            sum++;
        if (p2.isExpensiveProcedure())
            sum++;
        if (p3.isExpensiveProcedure())
            sum++;
        return sum;
    }

    /**
     * display procedures and summary
     * @param p1 first procedure - type procedure
     * @param p2 second procedure - type procedure
     * @param p3 third procedure - type procedure
     */
    private static void displaySummary (Procedure p1, Procedure p2, Procedure p3) {
        displayProcedure(p1);
        displayProcedure(p2);
        displayProcedure(p3);

        String totalCharge = formatCharge(calculateTotalCharges(p1, p2, p3));
        String averageCharge = formatCharge(calculateAverageCharge(p1, p2, p3));
        String highestCharge = findHighestChargeProcedure(p1, p2, p3).getProcedureName();

        System.out.println();

        System.out.println("Total Charges: " + totalCharge);
        System.out.println("Average Charge: " + averageCharge);
        System.out.println("Highest Charge Procedure: " + highestCharge);
        System.out.println("Number of Expensive Procedures: " + countExpensiveProcedures(p1, p2, p3));

        System.out.println("\nThe program was developed by a Student: Michael Jarman 09/25/26");
    }

    /**
     * format charge in US currency format
     * @param charge procedure charge - type double
     * @return formatted charge - type string
     */
    private static String formatCharge (double charge) {
        Locale currentLocale = Locale.US;
        var currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        return currencyFormatter.format(charge);
    }

    /**
     * This is a test harness to test some unused methods.
     * The project does not explicitly call for this requirement.
     */
    private static void runTests() {
        // default constructor check
        Patient p1 = new Patient();
        System.out.println(p1);
        System.out.println(p1.getContactSummary());
        System.out.println(p1.getLastFirstMiddle());

        // 3 arg constructor check
        Patient p2 = new Patient("Timmy", "Test", "Method");
        System.out.println(p2);
        System.out.println(p2.getContactSummary());
        System.out.println(p2.getLastFirstMiddle());
        System.out.println("hasSameCityState check (exp false): " + p2.hasSameCityState("AnyCity", "AnyState")); // prints false

        // with all arguments
        Patient p3 = new Patient("All", "Argument", "Constructor",
                "123 Main Street", "AnyCity", "AnyState", "99999",
                "999-999-9999", "Emergency Contact Name", "555-555-5555");
        System.out.println(p3);
        System.out.println(p3.getContactSummary());
        System.out.println(p3.getLastFirstMiddle());
        System.out.println("hasSameCityState check (exp true): " + p3.hasSameCityState("AnyCity", "AnyState")); // prints true

        Patient p4 = new Patient();
        p4.updateAddress("13 Main Street", "AnyCity", "AnyState", "99999");
        System.out.println(p4.getContactSummary());

        // default constructor check
        Procedure pr1 = new Procedure();
        System.out.println(pr1);
        displayProcedure(pr1);
        System.out.println("isPerformedBy check (exp true): " + pr1.isPerformedBy("Dr. Nicholas")); // returns true
        System.out.println("Price before discount: " + pr1.getProcedureCharge());
        pr1.applyDiscount(10000);
        System.out.println("Price after discount (10000%): " + pr1.getProcedureCharge());

        // 2 arg constructor check
        Procedure pr2 = new Procedure("Procedure Name", "01/01/2000");
        System.out.println(pr2);
        displayProcedure(pr2);
        System.out.println("Price before discount: " + pr2.getProcedureCharge());
        pr2.applyDiscount(-1);
        System.out.println("Price after discount (-1%): " + pr2.getProcedureCharge());

        // all arg constructor check and discount check
        Procedure pr3 = new Procedure("Procedure", "02/01/2001", "Dr. Doctor", 5555);
        System.out.println(pr3);
        System.out.println("isPerformedBy check (exp false): " + pr3.isPerformedBy("Dr. Nicholas")); // returns false
        System.out.println("Price before discount: " + pr3.getProcedureCharge());
        pr3.applyDiscount(55);
        System.out.println("Price after discount (55%): " + pr3.getProcedureCharge());
        displayProcedure(pr3);
    }
}