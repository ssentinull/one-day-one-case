import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static HashMap<Integer, Integer> setArrayMap(int[] arr){

        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        boolean isKeyExist;
        int amount, arrElement;

        for(int i = 0; i <= arr.length - 1; i++){
            arrElement = arr[i];
            isKeyExist = arrayMap.containsKey(arrElement);

            if(!isKeyExist)
                amount = 1;
            else   
                amount = arrayMap.get(arrElement) + 1;
            
            arrayMap.put(arrElement, amount);
        }

        return arrayMap;
    }

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {

        HashMap<Integer, Integer> beforeArrayMap = setArrayMap(brr);
        HashMap<Integer, Integer> afterArrayMap = setArrayMap(arr);

        boolean isNumberMissing;
        Integer beforeArrayNumberAmount, 
            afterArrayNumberAmount;
        ArrayList<Integer> missingElementsArrayList = new ArrayList<>();

        for(Integer missingNumber: beforeArrayMap.keySet()){
            beforeArrayNumberAmount = beforeArrayMap.get(missingNumber);
            afterArrayNumberAmount = afterArrayMap.get(missingNumber);

            if(afterArrayNumberAmount == null)
                afterArrayNumberAmount = 0;
            
            isNumberMissing = !afterArrayNumberAmount.equals(beforeArrayNumberAmount);

            if(isNumberMissing)
                missingElementsArrayList.add(missingNumber);
        }

        Collections.sort(missingElementsArrayList);
        
        int missingElementsArrayListSize = missingElementsArrayList.size();
        int[] missingElementsArray = new int[missingElementsArrayListSize];

        for(int i = 0; i <= missingElementsArrayListSize - 1; i++)
            missingElementsArray[i] = missingElementsArrayList.get(i).intValue(); 

        return missingElementsArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
