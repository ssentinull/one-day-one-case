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

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        HashMap<Integer, Integer> birdCategoryCountMap = new HashMap<Integer, Integer>();

        for(Integer i = 0; i <= arr.size() - 1; i++){
            Integer arrValue = arr.get(i);
            boolean isCategoryExist = birdCategoryCountMap.containsKey(arrValue);

            if(!isCategoryExist){
                birdCategoryCountMap.put(arrValue, 1);
                continue;
            } 

            Integer birdCategoryCount = birdCategoryCountMap.get(arrValue);
            
            birdCategoryCount += 1;
            birdCategoryCountMap.put(arrValue, birdCategoryCount);
        }

        Integer maxBirdCategory = Collections.max(birdCategoryCountMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();

        return maxBirdCategory;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
