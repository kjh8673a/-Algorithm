import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            A = A.replaceAll(arr[i], String.valueOf((char) (arr[i].charAt(0) + 32)));
        }

        System.out.println(A);
    }

}