import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int numCharsAdded = 0;
        boolean isPasswordContainDigist = password.matches(".*\\d.*"),
            isPasswordContainsUppercase = !password.equals(password.toLowerCase()),
            isPasswordContainsLowercase = !password.equals(password.toUpperCase()),
            isPasswordContainsSpecialChar = !password.matches("[A-Za-z0-9 ]*");

        if(!isPasswordContainDigist)
            numCharsAdded += 1;

        if(!isPasswordContainsUppercase)
            numCharsAdded += 1;

        if(!isPasswordContainsLowercase)
            numCharsAdded += 1;

        if(!isPasswordContainsSpecialChar)
            numCharsAdded += 1;

        if(numCharsAdded + n < 6)
            numCharsAdded += 6 - numCharsAdded - n; 

        return numCharsAdded;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
