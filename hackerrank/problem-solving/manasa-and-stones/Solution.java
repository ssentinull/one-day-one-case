import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {

        int[] consecStones = new int[n];
        int lowestVal = a < b ? a : b,
            highestVal = b > a ? b : a; 
        int lowestSum = (n - 1) * lowestVal;

        consecStones[0] = lowestSum;

        for(int i = 1; i < n; i++)
            consecStones[i] = consecStones[i - 1] - lowestVal + highestVal;
        
        Set<Integer> uniqueConsecStones = new HashSet<Integer>();

        for(int i = 0; i < consecStones.length; i++)
            uniqueConsecStones.add(new Integer(consecStones[i]));

        int[] sortedUniqueConsecStones = new int[uniqueConsecStones.size()];
        int idx = 0;

        for (Integer stone: uniqueConsecStones)
            sortedUniqueConsecStones[idx++] = stone.intValue();

        Arrays.sort(sortedUniqueConsecStones);

        return sortedUniqueConsecStones;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
