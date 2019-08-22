import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        // the starting Index for looping the j<m
        int startIdx = 0;
        // the sum for comparing to d
        int total = 0;
        // the total number of ways that Lily can portion her chocolate bar to share with Ron.
        int result = 0;
        for(int i = 0; i<s.size(); i++){
            // make the startIndex the same as i, if i = 2 then startIdx = 2
            startIdx = i;
            // To Break If ArrayOutOfBounds
            try{
                // if startIdx =2 and j = 0 then loop begin from s[2] to j<m
                for(int j = 0; j<m; j++){
                    total += s.get(startIdx+j);
                }
            }catch(Exception e){
                break;
            }
            if(total == d){
                // if total is the same as d then result will be added
                result++;
            }
            // after that reset the total to 0
            total= 0;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
