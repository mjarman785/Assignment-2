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

public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;

    private String streetAddress;
    private String cityName;
    private String stateName;
    private String zipCode;

    private String phone;

    private String emergencyContactName;
    private String emergencyContactPhone;

    /**
     * No-arg constructor. We initialize the variables
     */
    public Patient () {
        this.firstName = "Montgomery";
        this.middleName = "College";
        this.lastName = "Rockville";

        this.streetAddress = "51 Mannakee Street";
        this.cityName = "Rockville";
        this.stateName = "Maryland";
        this.zipCode = "20850";

        this.phone = "240-567-5000";

        this.emergencyContactName = "Counseling and Advising Rockville";
        this.emergencyContactPhone = "240-567-5063";
    }

    /**
     * Constructor with patient name only
     * @param first patient's first name - type string
     * @param middle patient's middle name - type string
     * @param last patient's last name - type string
     */
    public Patient (String first, String middle, String last) {
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;

        this.streetAddress = "51 Mannakee Street";
        this.cityName = "Rockville";
        this.stateName = "Maryland";
        this.zipCode = "20850";

        this.phone = "240-567-5000";

        this.emergencyContactName = "Counseling and Advising Rockville";
        this.emergencyContactPhone = "240-567-5063";
    }

    /**
     * Full constructor for patient object
     * @param first patient's first name - type string
     * @param middle patient's middle name - type string
     * @param last patient's last name - type string
     * @param address patient address - type string
     * @param city patient residence city - type string
     * @param state patient state of residence - type string
     * @param zip patient's zip code - type int
     * @param phone patient's phone number, ideally formatted in XXX-XXX-XXXX format  - type string
     * @param eContactName patient's emergency contact - type string
     * @param eContactPhone emergency contact's phone number - type string
     */
    public Patient (String first, String middle, String last,
                    String address, String city, String state, String zip,
                    String phone,
                    String eContactName, String eContactPhone) {
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;

        this.streetAddress = address;
        this.cityName = city;
        this.stateName = state;
        this.zipCode = zip;

        this.phone = phone;

        this.emergencyContactName = eContactName;
        this.emergencyContactPhone = eContactPhone;
    }

    /**
     * setter for first name
     * @param first patient's first name - type string
     */
    public void setFirstName (String first) {
        this.firstName = first;
    }

    /**
     * setter for middle name
     * @param middle patient's middle name - type string
     */
    public void setMiddleName (String middle) {
        this.middleName = middle;
    }

    /**
     * setter for last name
     * @param last patient's last name - type string
     */
    public void setLastName (String last) {
        this.lastName = last;
    }

    /**
     * setter for street address
     * @param address patient's street address - type string
     */
    public void setStreetAddress (String address) {
        this.streetAddress = address;
    }

    /**
     * setter for city
     * @param city patient's city - type string
     */
    public void setCityName (String city) {
        this.cityName = city;
    }

    /**
     * setter for state
     * @param state patient's state - type string
     */
    public void setStateName (String state) {
        this.stateName = state;
    }

    /**
     * setter for zip code
     * @param zip patient's zip code - type int
     */
    public void setZipCode (String zip) {
        this.zipCode = zip;
    }

    /**
     * setter for phone number
     * @param phoneNumber patient's phone number - type string
     */
    public void setPhone (String phoneNumber) {
        this.phone = phoneNumber;
    }

    /**
     * setter for emergency contact name
     * @param eContactName patient's emergency contact - type string
     */
    public void setEmergencyContactName (String eContactName) {
        this.emergencyContactName = eContactName;
    }

    /**
     * setter for emergency contact phone
     * @param eContactPhone emergency contact's phone number - type string
     */
    public void setEmergencyContactPhone (String eContactPhone) {
        this.emergencyContactPhone = eContactPhone;
    }

    /**
     * getter for first name
     * @return patient's first name - type string
     */
    public String getFirstName () {
        return firstName;
    }

    /**
     * getter for middle name
     * @return patient's middle name - type string
     */
    public String getMiddleName () {
        return middleName;
    }

    /**
     * getter for last name
     * @return patient's last name - type string
     */
    public String getLastName () {
        return lastName;
    }

    /**
     * getter for street address
     * @return patient's street address - type string
     */
    public String getStreetAddress () {
        return streetAddress;
    }

    /**
     * getter for city
     * @return patient's city - type string
     */
    public String getCityName () {
        return cityName;
    }

    /**
     * getter for state
     * @return patient's state - type string
     */
    public String getStateName () {
        return stateName;
    }

    /**
     * getter for zip
     * @return patient's zip code - type int
     */
    public String getZipCode () {
        return zipCode;
    }

    /**
     * getter for phone
     * @return patient's phone number - type string
     */
    public String getPhone () {
        return phone;
    }

    /**
     * getter for emergency contact name
     * @return patient's emergency contact - type string
     */
    public String getEmergencyContactName () {
        return emergencyContactName;
    }

    /**
     * getter for emergency contact phone
     * @return emergency contact's phone number - type string
     */
    public String getEmergencyContactPhone () {
        return emergencyContactPhone;
    }

    /**
     * builds full name from first / middle / last
     * @return patient's name formatted as first middle last - type string
     */
    public String buildFullName () {
        return firstName + " " + middleName + " " + lastName;
    }

    /**
     * builds address as street / city / state / zip
     * @return patient's address formatted as street city state zip - type string
     */
    public String buildAddress () {
        return streetAddress + " " + cityName + " " + stateName + " " + zipCode;
    }

    /**
     * build emergency contact as name / phone
     * @return patient's emergency contact info formatted as name phone - type string
     */
    public String buildEmergencyContact () {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    /**
     * everything to string
     * @return returns all info as one long string - type string
     */
    public String toString() {
        return buildFullName() + " " + buildAddress() + " " + getPhone() + " " + buildEmergencyContact();
    }

    /**
     * my horrifying phone validator built using a try/catch statement!
     * checks if number exists and if it's 12 digits,
     * then goes through entire number until it reaches the 3rd and 7th position (zero indexed), where it checks for a dash
     * any non-number character throws a NumberFormatException when integer parsing is attempte
     * @param phone phone number to be tested
     * @return result - type boolean
     */
    private boolean validatePhone (String phone) {
        if (phone == null || phone.length() != 12) {
            return false;
        }
        for (int i = 0; i <= 11; i++) {
            if (i == 3 || i == 7) {
                if (phone.charAt(i) != '-') {
                    return false;
                }
            } else {
                try  {
                    Integer.parseInt(String.valueOf(phone.charAt(i)));
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * uses the validatePhone method to check for valid phone number
     * @return result - type boolean
     */
    public boolean isValidPhoneNumber() {
        return validatePhone(phone);
    }

    /**
     * uses the validatePhone method to check for valid phone number
     * @return result - type boolean
     */
    public boolean isValidEmergencyPhoneNumber() {
        return validatePhone(emergencyContactPhone);
    }

    /**
     * formats name in last first middle
     * @return patient's name in last first middle format - type string
     */
    public String getLastFirstMiddle() {
        return lastName + ", " + firstName + " " + middleName;
    }

    /**
     * Checks if city and state matches record
     * @param city city name to be tested
     * @param state state name to be tested
     * @return result - type boolean
     */
    public boolean hasSameCityState (String city, String state) {
        if (cityName.equals(city) && stateName.equals(state))
            return true;
        return false;
    }

    /**
     * update address, will not return anything
     * @param street street address - type string
     * @param city city name - type string
     * @param state state name - type string
     * @param zip zip code - type string
     */
    public void updateAddress (String street, String city, String state, String zip) {
        streetAddress = street;
        cityName = city;
        stateName = state;
        zipCode = zip;
    }

    /**
     * build fully formatted contact summary
     * @return contact summary, formatted - type string
     */
    public String getContactSummary() {
        return "Name: " + buildFullName() + "\n" +
               "Address: " + buildAddress() + "\n" +
               "Phone Number: " + getPhone() + "\n" +
               "Emergency Contact: " + buildEmergencyContact() + "\n" +
               "Phone Valid: " + isValidPhoneNumber() + "\n" +
               "Emergency Phone Valid: " + isValidEmergencyPhoneNumber();
    }
}
