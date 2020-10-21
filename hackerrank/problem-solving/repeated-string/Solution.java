import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numOfAInInputString = 0;

        for(int i = 0; i <= s.length() - 1; i++)
            if(s.charAt(i) == 'a')
                numOfAInInputString++;

        long quotient = n / s.length();
        long numOfAByDivision = quotient * numOfAInInputString;

        long remainder = n % s.length();
        String inputStringSubstring = s.substring(0, (int) remainder);

        long numOfAByModulo = 0;
        for(int i = 0; i <= inputStringSubstring.length() - 1; i++)
            if(inputStringSubstring.charAt(i) == 'a')
                numOfAByModulo++;

        long numOfA = numOfAByDivision + numOfAByModulo;

        return numOfA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
