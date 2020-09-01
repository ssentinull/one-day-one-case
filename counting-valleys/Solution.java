import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        // early returns when the string length is <= 0
        if(n <= 0 || s.length() == 0)
            return 0;

        int valleys = 0,
         previousPosition = 0,
         currentPosition = 0,
         stringLength = n,
         index = 0;

        // loop until the index is the size of the given string length - 1
        while(index < stringLength){

            // increment the current position if there is a climb
            if(s.charAt(index) == 'U'){
                previousPosition = currentPosition;
                ++currentPosition;
            }
            
            // decrement the current position if there is a drop
            if(s.charAt(index) == 'D'){
                previousPosition = currentPosition;
                --currentPosition;
            }

            // increment the valleys counter if it is not the first iteration of the loop 
            // AND if the current position is at sea level AND if the previous position is from a descent
            if(index != 0 && currentPosition == 0 && previousPosition < 0)
                ++valleys;

            ++index;
        }

        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
