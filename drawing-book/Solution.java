import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {

        boolean isPagesOdd = n % 2 == 1;
        boolean isTargetPageNotNearEndPage = n - p != 1; 
        
        int forwardTurn = p / 2;
        int backwardTurn;

        if(isPagesOdd)
            backwardTurn = 0;
        else
            backwardTurn = 1;

        if(isTargetPageNotNearEndPage)
            backwardTurn = (n - p) / 2;

        if(forwardTurn <= backwardTurn)
            return forwardTurn;

        return backwardTurn;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
