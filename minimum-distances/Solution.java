import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {

        HashMap<Integer, ArrayList<Integer>> valueIndecesMap = new HashMap<>();
        ArrayList<Integer> tempList = null;

        for(int i = 0; i <= a.length - 1; i++){
            if(!valueIndecesMap.containsKey(a[i]))
                tempList = new ArrayList<Integer>();
            else
                tempList = valueIndecesMap.get(a[i]);

            tempList.add(i);
            valueIndecesMap.put(a[i], tempList);
        }

        Integer smallestDifference = -1;

        for (Map.Entry<Integer, ArrayList<Integer>> valueIndeces : valueIndecesMap.entrySet()){
            
            ArrayList indeces = valueIndeces.getValue();

            if(indeces.size() <= 1)
                continue;
            
            if(smallestDifference == -1)
                smallestDifference = Integer.MAX_VALUE;

            indeces.sort(Comparator.naturalOrder());

            for(int i = 0; i <= indeces.size() - 2; i++){

                int currentIndex = (int) indeces.get(i);
                int nextIndex = (int) indeces.get(i + 1);
                int difference = nextIndex - currentIndex;

                if(difference < smallestDifference)
                    smallestDifference = difference; 
            }
        }

        return smallestDifference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
