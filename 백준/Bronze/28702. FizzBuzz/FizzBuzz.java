import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int num = 0;
        if (!isFizzOrBuzz(a)) {
            num = Integer.parseInt(a) + 3;
        } else if (!isFizzOrBuzz(b)) {
            num = Integer.parseInt(b) + 2;
        } else {
            num = Integer.parseInt(c) + 1;
        }

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }

    private static boolean isFizzOrBuzz(String s) {
        return s.equals("FizzBuzz") || s.equals("Fizz") || s.equals("Buzz");
    }

}