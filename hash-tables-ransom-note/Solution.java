import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        boolean isMagazineValid = true;
        Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>();

        for(int i = 0; i < magazine.length; i++){
            String magazineKey = magazine[i];
            boolean isContainsKey = hashTable.containsKey(magazineKey); 

            if(!isContainsKey){
                hashTable.put(magazineKey, 1);
            } else {
                int hashTableCount = hashTable.get(magazineKey);

                ++hashTableCount;
                hashTable.put(magazineKey, hashTableCount);
            }
        }

        for(int i = 0; i < note.length; i++){
            String noteKey = note[i];
            boolean isExistInHashTable = hashTable.containsKey(noteKey);

            if(!isExistInHashTable){
                isMagazineValid = false;
                break;
            } 

            Integer hashTableCount = hashTable.get(noteKey);

            if(hashTableCount <= 0){
                isMagazineValid = false;
                break;
            } else {
                --hashTableCount;
                hashTable.put(noteKey, hashTableCount);
            }
        }

        if(!isMagazineValid){
            System.out.print("No");
        } else {
            System.out.print("Yes");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
