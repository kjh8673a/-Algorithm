import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] arr = br.readLine().split("0");

        long left = arr[0].chars().filter(c -> c == '@').count();
        long right = arr[1].chars().filter(c -> c == '@').count();

        System.out.println(left + " " + right);
    }
}
