import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        char[] sCharArray = s.toCharArray();
        int sIndex = 0,
            sLength = sCharArray.length;
        double sLengthSqrt = Math.sqrt(sLength);
        int row =(int) Math.floor(sLengthSqrt),
            col =(int) Math.ceil(sLengthSqrt);
        String encryptedString = "";
        
        if(row * col < sLength)
            if(col < row)
                col = row;
            else
                row = col;

        for(int j = 0; j < col; j++){
            for(int i = 0; i < row; i++){
                sIndex = (i * col) + j;
                
                try{
                    encryptedString += sCharArray[sIndex];
                }
                catch(Exception e){
                    continue;
                }
            }
            
            encryptedString += " ";
        }

        return encryptedString;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
