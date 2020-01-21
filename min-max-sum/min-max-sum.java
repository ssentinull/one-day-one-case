import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        boolean isAllElmsSame = true;
        long firstElm = arr[0];

        for(int i = 0; i <= arr.length - 2; i++){
            if(arr[i] != arr[i + 1])
                isAllElmsSame = false;
        }

        if(isAllElmsSame == true){
            long elmTotal = firstElm * 4;
            System.out.println(elmTotal + " " + elmTotal);
            return;
        }

        long minElm = 0, maxElm = 0;

        for(int i = 0; i <= arr.length - 1; i++){
            if(i == 0){
                minElm = arr[i];
                maxElm = arr[i];
                continue;
            }

            if(arr[i] < minElm)
                minElm = arr[i];
            
            if(arr[i] > maxElm)
                maxElm = arr[i];
        }

        long minTotal = 0, maxTotal = 0;

        for(int i = 0; i <= arr.length - 1; i++){
            if(arr[i] != minElm){
                maxTotal += arr[i];
            }

            if(arr[i] != maxElm){
                minTotal += arr[i];
            }
        } 

        System.out.println(minTotal + " " + maxTotal);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
