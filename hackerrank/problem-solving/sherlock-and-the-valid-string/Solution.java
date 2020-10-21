import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if(s.isEmpty()) return "NO";
        if(s.length() <= 3) return "YES";
        char[] achar = s.toCharArray();
        int[] banyakAbjad = new int[26];
        for(int eachChar: achar){
            banyakAbjad[eachChar-'a']++;
        }
        Arrays.sort(banyakAbjad);
        int i = 0;
        while(banyakAbjad[i] == 0){
            i++;
        }
        System.out.println(Arrays.toString(banyakAbjad));
        int min = banyakAbjad[i];
        int max = banyakAbjad[25];
        if(min==max) return "YES";
        else{
    //             letters is an array acting like a hashmap that stores the frequency information of the alphabet letters 'a' - 'z'. There are 26 letters.
// letters is sorted so the most frequent letter appears at letters[25].
// max > letters[24] makes sure there is exactly 1 letter that appears 1 more time than the other letters.
//misal jika i=24 value = 2 dan i=25 value = 3 maka dapat dipastikan 1 huruf dapat dihapus di i=25 sehingga value=3 menjadi value = 2 
            if(((max-min==1)&&(max>banyakAbjad[24])) || ((min==1)&&(banyakAbjad[i+1] ==max))){
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
