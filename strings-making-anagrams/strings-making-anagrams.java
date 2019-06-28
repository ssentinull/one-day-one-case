// Website: Hackerrank
// URL: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings 

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int aStringLength = a.length();
        int bStringLength = b.length();

        int aCharacterCounts[] = new int[26];
        int bCharacterCounts[] = new int[26];

        char[] alphabetsArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(int i = 0; i < aStringLength; i++)
            for(int j = 0; j < alphabetsArray.length; j++)
                if(a.charAt(i) == alphabetsArray[j])
                    ++aCharacterCounts[j];

        for(int i = 0; i < bStringLength; i++)
            for(int j = 0; j < alphabetsArray.length; j++)
                if(b.charAt(i) == alphabetsArray[j])
                    ++bCharacterCounts[j];

        int deletionCount = 0;

        for(int i = 0; i < alphabetsArray.length; i++)
            if(aCharacterCounts[i] < bCharacterCounts[i])
                deletionCount += bCharacterCounts[i] - aCharacterCounts[i];
            else if(aCharacterCounts[i] > bCharacterCounts[i]) 
                deletionCount += aCharacterCounts[i] - bCharacterCounts[i];
        
        return deletionCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}