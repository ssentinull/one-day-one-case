import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {

        Map<Integer, ArrayList<Integer>> arrValueIndexMap = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i <= arr.length - 1; i++)
            if(!arrValueIndexMap.containsKey(arr[i]))
                arrValueIndexMap.put(arr[i], new ArrayList<Integer>(Arrays.asList(i)));
            else {
                ArrayList arrIndex = new ArrayList(arrValueIndexMap.get(arr[i]));
                arrIndex.add(i);
                arrValueIndexMap.put(arr[i], arrIndex);
            }

        Integer totalNumBeautifulSet = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> valueIndex : arrValueIndexMap.entrySet()) {
            Integer firstValue = valueIndex.getKey();
            ArrayList firstValueIndexList = valueIndex.getValue();

            Integer secondValue = firstValue + d;
            Integer thirdValue = firstValue + d * 2;

            if(!arrValueIndexMap.containsKey(secondValue) || !arrValueIndexMap.containsKey(thirdValue))
                continue;

            ArrayList secondValueIndexList = arrValueIndexMap.get(secondValue);
            ArrayList thirdValueIndexList = arrValueIndexMap.get(thirdValue);

            Integer numBeautifulSet = firstValueIndexList.size() * secondValueIndexList.size() * thirdValueIndexList.size();

            totalNumBeautifulSet += numBeautifulSet;
        }

        return totalNumBeautifulSet;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
