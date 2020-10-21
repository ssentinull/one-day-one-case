import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {

        Character[] targetCharArr = 
            "hackerrank".chars().mapToObj(c -> (char)c).toArray(Character[]::new),
            stringCharArr = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new); 
        
        Queue<Character> queue = new LinkedList<>(Arrays.asList(targetCharArr));

        for(Character stringChar : stringCharArr)
            if(stringChar.equals(queue.peek()))
                queue.remove();

        String isHackerrankInString = "NO";

        if(queue.isEmpty())
            isHackerrankInString = "YES";

        return isHackerrankInString;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
