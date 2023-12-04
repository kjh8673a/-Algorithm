import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        boolean containSeven = containSeven(num);
        boolean divisibleSeven = divisibleSeven(Integer.parseInt(num));

        int ans = 0;
        if (containSeven && divisibleSeven) {
            ans = 3;
        } else if (containSeven) {
            ans = 2;
        } else if (divisibleSeven) {
            ans = 1;
        }

        System.out.println(ans);
    }

    private static boolean divisibleSeven(int num) {
        if (num % 7 == 0) {
            return true;
        }
        return false;
    }

    private static boolean containSeven(String num) {
        if (num.contains("7")) {
            return true;
        }
        return false;
    }
}