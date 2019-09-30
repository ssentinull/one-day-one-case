// Website: Hackkerrank
// URL: https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean isSubstr = false;
        Hashtable<String, Integer> substrHashTable = new Hashtable<String, Integer>();

        for(int i = 0; i < s1.length() - 1; i++){
            String key = s1.substring(i, i + 1);
            boolean isContainsKey = substrHashTable.containsKey(key);

            if(isContainsKey){
                continue;
            } else {
                substrHashTable.put(key, 1);
            }
        }

        for(int i = 0; i < s2.length() - 1; i++){
            String key = s2.substring(i, i + 1);
            isSubstr = substrHashTable.containsKey(key);

            if(isSubstr){
                return "YES";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
