import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String number = br.readLine();
            if (number.equals("0")) {
                break;
            }

            int idx = 0;
            while (true) {
                if (isPalindrome(number, idx)) {
                    break;
                }
                idx++;
            }

            sb.append(idx).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean isPalindrome(String number, int idx) {
        int len = number.length();
        String num = String.valueOf(Integer.parseInt(number) + idx);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - num.length(); i++) {
            sb.append("0");
        }
        sb.append(num);

        return sb.toString().equals(sb.reverse().toString());
    }

}