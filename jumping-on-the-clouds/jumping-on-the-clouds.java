// Website: Hackerrank
// URL: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        if(c.length == 0)
            return 0;

        int index = 0;
        int hops = 0;

        // c.length - 1 is used because by the time iteration number [c.length - 1] is executed,
        // the newest index would be c.length hence breaking the loop
        while(index < c.length - 1){

            // checks if the loop is still able to validate the value
            // that is located next next to the current state
            if(index < c.length - 2){

                // if it's a cumulus clouds, increment by 2
                if(c[index + 2] == 0)
                    index += 2;
                
                // because there is no thunderclouds that are located right next to each other
                // this automatically means that the next cloud would be a cumulus,
                // therefore the index is incremented by 1
                else 
                    ++index;                
            }
            else 
                ++index;
            
            hops++;
        }

        return hops;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
