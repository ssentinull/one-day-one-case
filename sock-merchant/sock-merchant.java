// Website: Hackkerrank
// URL: https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        // returns early if the number of array is 0, or if the array is empty
        if(n == 0 || ar.length == 0)
            return 0;

        int numPair = 0;
        int index = 0;
        
        // sort the array
        Arrays.sort(ar);

        // while loop is used instead of for because 
        // the number of increments can vary from 1 - 2
        while(index < ar.length - 1){

            // increment the number of pairs if a pair is found
            // and increment the index by 2
            if(ar[index] == ar[index + 1]){
                numPair++;
                index += 2;
            } 

            // if not pair is found, increment the index by 1 
            else {
                index++;
            }
        }

        return numPair;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
