import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static Integer[] getPickedFlavorIndeces(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {

        Integer[] flavorIndeces = new Integer[2];

        flavorIndeces[0] = firstQueue.remove();
        flavorIndeces[1] = secondQueue.remove();

        return flavorIndeces;
    }

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        
        Hashtable<Integer, Queue<Integer>> costIndeces = new Hashtable<Integer, Queue<Integer>>();

        for(int i = 0; i <= cost.length - 1; i++){
            Queue queue = null;
            boolean isCostExist = costIndeces.containsKey(cost[i]);
            
            if(!isCostExist)
                queue = new LinkedList<Integer>();
            else
                queue = costIndeces.get(cost[i]);

            queue.add(i + 1);
            costIndeces.put(cost[i], queue);
        }

        Integer[] pickedFlavorIndeces = new Integer[2];
        Set<Integer> costs = costIndeces.keySet();
        
        for(Integer iCost: costs){
            Integer costDifference = money - iCost;
            boolean isCostDifferenceExist = costIndeces.containsKey(costDifference);

            if(!isCostDifferenceExist)
                continue;

            if(iCost != costDifference){
                Queue<Integer> firstFlavorIndeces = costIndeces.get(iCost);
                Queue<Integer> secondFlavorIndeces = costIndeces.get(costDifference);

                pickedFlavorIndeces = getPickedFlavorIndeces(firstFlavorIndeces, secondFlavorIndeces);
                break;
            }

            Queue<Integer> flavorIndeces = costIndeces.get(iCost);
            
            pickedFlavorIndeces = getPickedFlavorIndeces(flavorIndeces, flavorIndeces);
            break;
        }
        
        if(pickedFlavorIndeces[0] > pickedFlavorIndeces[1]){
            Integer tempIndex = pickedFlavorIndeces[0];
            pickedFlavorIndeces[0] = pickedFlavorIndeces[1];
            pickedFlavorIndeces[1] = tempIndex;
        }

        System.out.println(pickedFlavorIndeces[0] + " " + pickedFlavorIndeces[1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
