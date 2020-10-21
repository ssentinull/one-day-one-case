import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {

        boolean isCharExist;
        int characterAmount;
        String stringCharacter;
        HashMap<String, Integer> characterAmountMap = new HashMap<>();

        for(char character : s.toCharArray()){
            stringCharacter = Character.toString(character);
            isCharExist = characterAmountMap.containsKey(stringCharacter);

            if(!isCharExist)
                characterAmount = 1;
            else
                characterAmount = characterAmountMap.get(stringCharacter) + 1;

            characterAmountMap.put(stringCharacter, characterAmount);
        }

        boolean isCharacterAmountOdd, isOddAmountExist = false;
        String stringPalindromeable = "YES";

        for (Integer amount : characterAmountMap.values()) {
            isCharacterAmountOdd = amount % 2 == 1;
            
            if(isCharacterAmountOdd && isOddAmountExist){
                stringPalindromeable = "NO";
                break;
            }

            if(isCharacterAmountOdd && !isOddAmountExist)
                isOddAmountExist = true;
        }

        return stringPalindromeable;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
