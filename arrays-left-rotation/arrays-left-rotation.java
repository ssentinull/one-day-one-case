// Website: Hackerrank
// URL: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        
        int arrayLength = a.length;
        int switchIndex = d;

        // early returns if the given array is empty or the array doesnt need to be switched
        if(arrayLength == 0 || switchIndex == 0)
            return a;

        int iterationIndex = 0;
        int[] givenArray = a;
        int[] newArray = new int[arrayLength];

        // loops until the iteration index is the size of array length - 1
        while(iterationIndex < arrayLength){
            
            // places the item from the given array that's located in the switch index
            // to a new array of index iteration index
            newArray[iterationIndex] = givenArray[switchIndex];

            ++switchIndex;

            // restarts the switch index once it has reached
            // the end of the given array
            if(switchIndex >= arrayLength)
                switchIndex = 0;
                
            ++iterationIndex;
        }

        return newArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
