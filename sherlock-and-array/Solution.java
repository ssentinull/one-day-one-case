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

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        String listIsBalanced = "YES";
        int listSize = arr.size();
        boolean isListSizeInvalid = listSize == 2 || listSize == 0;

        if(isListSizeInvalid)
            listIsBalanced = "NO";

        Integer zeroElementAmount = 0, nonZeroElementAmount = 0;

        for(int i = 0; i <= listSize - 1; i++)
            if(arr.get(i) == 0)
                zeroElementAmount += 1;
            else
                nonZeroElementAmount += 1;

        boolean isListConsistOfZeros = zeroElementAmount == listSize - 1 && nonZeroElementAmount == 1;

        if(!isListConsistOfZeros && !isListSizeInvalid){

            int indexCounter = listSize, 
                forwardIndex = 0, 
                backwardIndex = listSize - 1,
                indexLimit = 3,
                forwardValue = arr.get(forwardIndex),
                backwardValue = arr.get(backwardIndex),
                currentForwardValue, currentBackwardValue;

            while(true){
                
                if(indexCounter == indexLimit)
                    break;

                if(forwardValue >= backwardValue){
                    backwardIndex -= 1;
                    backwardValue += arr.get(backwardIndex);
                } else {
                    forwardIndex += 1;
                    forwardValue += arr.get(forwardIndex);
                }

                indexCounter -= 1;
            }

            if(forwardValue != backwardValue)
                listIsBalanced = "NO";
        }

        return listIsBalanced;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
