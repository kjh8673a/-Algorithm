import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        if (len % 2 != 0) {
            len--;
        }

        int answer = 0;
        loop: for (int i = len; i > 0; i -= 2) {
            for (int j = 0; j <= s.length() - i; j++) {
                String tmp = s.substring(j, j + i);
                int mid = (tmp.length() / 2);

                int left = 0;
                for (int k = 0; k < mid; k++) {
                    left += (tmp.charAt(k) - '0');
                }

                int right = 0;
                for (int k = mid; k < tmp.length(); k++) {
                    right += (tmp.charAt(k) - '0');
                }

                if (left == right) {
                    answer = i;
                    break loop;
                }
            }
        }

        System.out.println(answer);
    }

}