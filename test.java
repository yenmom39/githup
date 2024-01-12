import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCardParser {

    public static void main(String[] args) {
        String idCardString = "IDKHM1603633111<<<<<<<<<<<<<<<,9501016M2406215KHM<<<<<<<<<<<6,MEN<<CHENDA<<<<<<<<<<<<<<<<<<<,";

        // Extract fields using regular expressions
        Pattern pattern = Pattern.compile("IDKHM(\\d{9}),(\\d{6})(\\d)(\\d{6})(\\d{2})(\\d{2})(\\d{5})(.{5})(.{15}),");
        Matcher matcher = pattern.matcher(idCardString);
        if (matcher.find()) {
            String idNumber = matcher.group(1);
            String birthDate = matcher.group(2).substring(0, 2) + "/" + matcher.group(2).substring(2, 4) + "/" + "19" + matcher.group(2).substring(4, 6);
            String gender = matcher.group(3);
            String firstName = matcher.group(8);
            String lastName = matcher.group(9);
            String expiryDate = "20" + matcher.group(4) + "/" + matcher.group(5) + "/" + matcher.group(6);

            // Print the extracted information
            System.out.println("ID Number: " + idNumber);
            System.out.println("Birth Date: " + birthDate);
            System.out.println("Gender: " + gender);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Expiry Date: " + expiryDate);
        } else {
            System.out.println("Invalid ID card string format");
        }
    }
}
