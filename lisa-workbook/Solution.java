import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {

        int pageNumber = 1,
            problemsInAPage = 0,
            numProblems,
            currentProblems;
        boolean isProblemsStillFitInPage = true;

        ArrayList<Integer> problemList;
        HashMap<Integer, ArrayList<Integer>> pageProblemsMap = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i <= arr.length - 1; i++){
            numProblems = arr[i];
            currentProblems = 0;
            isProblemsStillFitInPage = true;

            while(isProblemsStillFitInPage){
                problemList = new ArrayList<Integer>();
                
                if(currentProblems + k >= numProblems){
                    for(int m = currentProblems + 1; m <= numProblems; m++)
                        problemList.add(m);

                    isProblemsStillFitInPage = false;
                }else
                    for(int j = currentProblems + 1; j <= currentProblems + k; j++)
                        problemList.add(j);

                pageProblemsMap.put(pageNumber, problemList);
                currentProblems += k;
                pageNumber++;
            }
        }

        int numSpecialProblems = 0;
        Integer page;
        ArrayList problems;
        
        for (Map.Entry<Integer, ArrayList<Integer>> pageProblems : pageProblemsMap.entrySet()) {
            page = pageProblems.getKey();
            problems = pageProblems.getValue();

            if(problems.contains(page))
                numSpecialProblems++;
        }

        return numSpecialProblems;
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

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
