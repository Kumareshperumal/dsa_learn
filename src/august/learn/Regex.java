package august.learn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        regexDay1();
//        regexDay2();
    }

    private static void regexDay2() {
        /*
        1. * - 0 or more times a* - aa, aaa
        2. + - 1 or more times a, aa
        3. ? - 0 or 1 times a? "", a.
        4. {n} - exactly n times \d{3} - 123.
        5. {n, }at least n times \d{2 , } - 12, 123, 1234
        6. {m, n} b/n m and n times \d{2,4} - 12, 123, 1234
        7 . - any single character(except newline)
         */
        //Exactly four digit for a pin code.
//        String input = "1234";
//        String regex = "^\\d{4}$";

        //Match a username 6-12 word characters.
//        String input = "abc_1123";
//        String regex = "^\\w{6,12}$";

        //Match any string that contains at least 3 digits.
//        String input = "abcd123abc123";
//        String regex = ".*\\d{3,}.*$";

        //Match a word with optional 's' at the end.
//        String input = "abcdfs";
//        String regex = "^\\w+(s)?$";

        //Match an optional country
        String input = "+91 9234567809";
        String regex = "^(\\+91)?+\\s?\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String output = matcher.find() ?"Match found" : "No match";
        System.out.println(output);
    }

    private static void regexDay1() {
        String input = "Step 1: Create a Tesla Account\n" +
                "\n" +
                "Create a Tesla account and ensure it has a verified email and multi-factor authentication enabled.\n" +
                "\n" +
                "Create Account\n" +
                "Step 2: Create an Application\n" +
                "\n" +
                "Click the button below to request app access. Provide legal business details, application name, description, and purpose of usage.\n" +
                "\n" +
                "While requesting access, select the scopes used by the application. Reference the authentication overview page for a list of available scopes.\n" +
                "\n" +
                "Note: account creation requests can be automatically rejected if the application name already exists.\n" +
                "\n" +
                "Create Application and Access Dashboard\n" +
                "Step 3: Generate a Public/Private Key Pair\n" +
                "\n" +
                "A public key must be hosted on the application's domain before making calls to Fleet API.\n" +
                "\n" +
                "The key is used to validate ownership of the domain and provide additional security when using Vehicle Commands and Fleet Telemetry.\n" +
                "\n" +
                "To create a private key, run:\n" +
                "\n" +
                "openssl ecparam -name prime256v1 -genkey -noout -out private-key.pem\n" +
                "Then, generate the associated public key.\n" +
                "\n" +
                "openssl ec -in private-key.pem -pubout -out public-key.pem\n" +
                "This public key should be available at:\n" +
                "\n" +
                "https://developer-domain.com/.well-known/appspecific/com.tesla.3p.public-key.pem\n" +
                "Note: private-key.pem needs to be kept secret and should not be hosted on a domain.\n" +
                "\n" +
                "Step 4: Call the Register Endpoint\n" +
                "\n" +
                "Next, generate a partner authentication token and use it to call the register endpoint to complete registration with Fleet API.\n" +
                "\n";
//        String regex = "^[\\w\\d]{5}+$";
//        String regex = "^a.*z$";
        String regex = "(?m)^Step \\d{1,2}: (.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
//        String output = matcher.find()?"Match found":"No match";
//        System.out.println(output);

        //input = "Step 12: This is a test\n";

//         pattern = Pattern.compile("Step \\d{0,2}: (.+)");
//         matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println(matcher.group(1));
        }
//        if (matcher.find()) {
//            System.out.println("Matched: " + matcher.groupCount());
//        } else {
//            System.out.println("No match");
//        }


    }
}
