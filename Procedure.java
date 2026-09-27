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

public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String procedurePractitioner;
    private double procedureCharge;
    public Locale currentLocale = Locale.US;

    /**
     * This is our no-arg constructor. It initializes the procedure to default values.
     */
    public Procedure () {
        this.procedureName = "Medication Adjustment";
        this.procedureDate = "01/01/1970";
        this.procedurePractitioner = "Dr. Nicholas";
        this.procedureCharge = 250.00;
    }

    /**
     * This constructor initializes name and epoch
     * @param name procedure name - type string
     * @param date procedure time - type string
     */
    public Procedure(String name, String date) {
        this.procedureName = name;
        this.procedureDate = date;
        this.procedurePractitioner = "Dr. Nicholas";
        this.procedureCharge = 250.00;

    }

    /**
     * This constructor initializes all attributes
     * @param name procedure name - type string
     * @param date procedure time - type string
     * @param practitioner practitioner name - type string
     * @param charge procedure charge - type double
     */
    public Procedure(String name, String date, String practitioner, double charge) {
        this.procedureName = name;
        this.procedureDate = date;
        this.procedurePractitioner = practitioner;
        this.procedureCharge = charge;
    }

    /**
     * setter for procedure name
     * @param name procedure name - type string
     */
    public void setProcedureName (String name) {
        this.procedureName = name;
    }

    /**
     * setter for procedure date
     * @param date - type string
     */
    public void setProcedureDate (String date) {
        this.procedureDate = date;
    }

    /**
     * setter for practitioner
     * @param practitioner practitioner name - type string
     */
    public void setProcedurePractitioner (String practitioner) {
        this.procedurePractitioner = practitioner;
    }
    /**
     * setter for procedure charge
     * @param charge procedure charge - type double
     */
    public void setProcedureCharge (double charge) {
        this.procedureCharge = charge;
    }

    /**
     * getter for procedure name
     * @return procedure name - type string
     */
    public String getProcedureName () {
        return procedureName;
    }

    /**
     * getter for procedure date
     * @return procedure date = type string
     */
    public String getProcedureDate () {
        return procedureDate;
    }

    /**
     * getter for practitioner
     * @return practitioner - type string
     */
    public String getProcedurePractitioner () {
        return procedurePractitioner;
    }

    /**
     * getter for procedure charge
     * @return procedure charge - type double
     */
    public double getProcedureCharge () {
        return procedureCharge;
    }

    /**
     * return true if procedure is over 1000.00 monetary units
     * @return procedure expensiveness - type boolean
     */
    public boolean isExpensiveProcedure () {
        if (procedureCharge >= 1000.00) {
            return true;
        }
        return false;
    }

    /**
     * apply discount from 0-100 percent, don't set anything if invalid
     * @param percent discount percentage - type double
     */
    public void applyDiscount (double percent) {
        if (percent >= 0 && percent <= 100)
            procedureCharge = procedureCharge - ((procedureCharge * percent) / 100);
    }

    /**
     * check if procedure performed by certain practitioner
     * @param practitionerName name to check against - type string
     * @return true if matches - type boolean
     */
    public boolean isPerformedBy (String practitionerName) {
        if (procedurePractitioner.equals(practitionerName))
            return true;
        return false;
    }

    /**
     * Return formatted charge based on locale. Forced to US locale to comply with assignment.
     * @return formatted money string
     */
    public String getFormattedCharge () {
        var currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        return currencyFormatter.format(procedureCharge);
    }

    /**
     * Get charge category
     * @return charge category - type string
     */
    public String getChargeCategory () {
        if (procedureCharge <= 250.00) {
            return "Low";
        } else if (procedureCharge < 1000.00) {
            return "Medium";
        } else {
            return "High";
        }
    }

    /**
     * all information in one string
     * @return all information in one long string - type string
     */
    public String toString() {
        return getProcedureName() + " " + getProcedureDate() + " " + getProcedurePractitioner() +
                " " + getProcedureCharge() + " " + getFormattedCharge() + " " + isExpensiveProcedure() +
                " " + getChargeCategory();
    }
}
