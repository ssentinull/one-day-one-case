import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        String canStringProcessed = "No";
        boolean isStringsDuplicate = s.equals(t);

        int sLength = s.length(),
            tLength = t.length();
        int divergentIdx = sLength,
            longestString = sLength > tLength ? sLength : tLength;        

        for(int i = 0; i < longestString; i++){
            try{
                if(s.charAt(i) != t.charAt(i)){
                    divergentIdx = i;
                    break;
                }
            }catch(Exception e){
                divergentIdx = i;
                break;
            }
        }

        int totalStrLen = sLength + tLength,
            strLenDiff = (sLength - divergentIdx) + (tLength - divergentIdx);
        boolean isKEqualsStrLenDiff = k == strLenDiff,
            isKBiggerThanTotalStrLen = k >= totalStrLen,
            isKDiffModEven = (k - strLenDiff) % 2 == 0,
            isKDiffNegative = (k - strLenDiff) <= -1;

        if(isKEqualsStrLenDiff || isKBiggerThanTotalStrLen || (isKDiffModEven && !isKDiffNegative))
            canStringProcessed = "Yes";

        return canStringProcessed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
