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
            
            int stringSize = s.length();  

            // early returns if n or size of string is 0
            if(n <= 0 || stringSize <= 0)
                return 0;

            // early returns if the string only consists of a letter other than 'a'
            if(s.charAt(0) != 'a' && s.length() == 1)
                return 0;

            // if the string only consist of the letter 'a', return the value of n
            if(s.charAt(0) == 'a' && s.length() == 1)
                return n;

            int arraySize = (int) n;
            
            char[] charArray = new char[arraySize];

            int globalIndex = 0;
            int stringIndex = 0;
            
            // loop until the global index is the size of n - 1
            while(globalIndex < arraySize){

                // loop for how many characters in the given string OR
                // until the global index is the size of n - 1 (this is done
                // so that the new char array doesnt go over the limit of n)
                while(globalIndex < arraySize && stringIndex < stringSize){

                    // append the char of the given string at index stringIndex 
                    // to the char array at index globalIndex
                    charArray[globalIndex] = s.charAt(stringIndex);

                    ++stringIndex;
                    ++globalIndex;
                }

                stringIndex = 0;
            }

            int aCounter = 0;

            // counts how many 'a's are in the char array
            for(int i = 0; i < arraySize; i++)
                if(charArray[i] == 'a')
                    aCounter++;

            return aCounter;
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
