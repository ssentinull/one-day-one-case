import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        Hashtable<Integer, Integer> arrValuesTable = new Hashtable<Integer, Integer>();

        for(int i = 0; i <= arr.length - 1; i++){
            Integer amount = 1;
            boolean isValueExist = arrValuesTable.containsKey(arr[i]); 

            if(isValueExist){
                amount = arrValuesTable.get(arr[i]);
                amount += 1;
            } 

            arrValuesTable.put(arr[i], amount);
        }

        Integer totalNumPairs = 0;
        Set<Integer> arrValues = arrValuesTable.keySet();

        for(Integer arrValue: arrValues){
            Integer targetMinuend = arrValue - k;
            boolean isTargetMinuendExist = arrValuesTable.containsKey(targetMinuend);

            if(!isTargetMinuendExist)
                continue;

            Integer arrValueAmount = arrValuesTable.get(arrValue);
            Integer targetMinuendAmount = arrValuesTable.get(targetMinuend);
            Integer arrValueAndMinuendPairsProduct = arrValueAmount * targetMinuendAmount;

            totalNumPairs += arrValueAndMinuendPairsProduct;
        }    

        return totalNumPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
