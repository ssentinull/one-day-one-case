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
        char[] sToChar = s.toCharArray();
        int lengthS = sToChar.length;
        double decSqrt = Math.sqrt(lengthS);
        int row =(int) Math.floor(decSqrt);
        int col =(int) Math.ceil(decSqrt);
        StringBuilder sb = new StringBuilder();
        if(row*col >= lengthS){
          for(int j=0;j<col;j++){
              for(int i = 0;i<row;i++){
                  int stringIndex = (i*col)+(j*1);
                  try{
                      sb.append(sToChar[stringIndex]);
                  }catch(Exception e){
                      continue;

                  }
              }
              sb.append(" ");
          }
          return sb.toString();  
        }else{
            System.out.print("row = "+row +" col="+col);
            if(col<row){
                col = row;
                System.out.print("col = "+col);
            }else{
                row = col;
                System.out.print("row = "+row);
            }
            for(int j=0;j<col;j++){
              for(int i = 0;i<row;i++){
                  int stringIndex = (i*col)+(j*1);
                System.out.print(stringIndex+" ");
                  try{
                      sb.append(sToChar[stringIndex]);
                  }catch(Exception e){
                      continue;
                  }
              }
              sb.append(" ");
          }
          return sb.toString();
        }
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
