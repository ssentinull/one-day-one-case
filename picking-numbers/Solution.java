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

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here

        HashMap<Integer, Integer> numberAmountMap = new HashMap<>();
        Integer iNumber, amount;
        boolean isNumberInMap;

        for(int i = 0; i <= a.size() - 1; i++){
            iNumber = a.get(i);
            isNumberInMap = numberAmountMap.containsKey(iNumber);
            
            if(!isNumberInMap)
                amount = 1;
            else
                amount = numberAmountMap.get(iNumber) + 1;

            numberAmountMap.put(iNumber, amount);
        }

        boolean isCurrentNumberExistInMap, isNextNumberExistInMap;
        Integer currentNumberAmount, 
            nextNumberAmount,
            currentSubarray, 
            longestSubarray = 0, 
            biggestAmountInList = 0,
            biggestNumberInList = Collections.max(a);
        
        for (Integer iAmount : numberAmountMap.values()) 
            if(iAmount > biggestAmountInList)
                biggestAmountInList = iAmount;

        for(int i = 0; i <= biggestNumberInList - 1; i++){
            isCurrentNumberExistInMap = numberAmountMap.containsKey(i);
            isNextNumberExistInMap = numberAmountMap.containsKey(i + 1);

            if(!(isCurrentNumberExistInMap && isNextNumberExistInMap))
                continue;
            
            currentNumberAmount = numberAmountMap.get(i);
            nextNumberAmount = numberAmountMap.get(i + 1);

            currentSubarray = currentNumberAmount + nextNumberAmount;

            if(currentSubarray > longestSubarray)
                longestSubarray = currentSubarray; 
        }

        if(biggestAmountInList > longestSubarray)
            longestSubarray = biggestAmountInList;

        return longestSubarray;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
