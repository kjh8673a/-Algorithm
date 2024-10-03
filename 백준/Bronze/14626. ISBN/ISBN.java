import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            char ch = num.charAt(i);
            if (ch != '*') {
                if (i % 2 == 0) {
                    sum += (ch - '0');
                } else {
                    sum += (ch - '0') * 3;
                }
            } else {
                if (i % 2 != 0) {
                    flag = true;
                }
            }
        }

        int answer = 0;
        int check = num.charAt(12) - '0';
        for (int i = 0; i < 10; i++) {
            if (!flag) {
                if ((sum + i + check) % 10 == 0) {
                    answer = i;
                    break;
                }
            } else {
                if ((sum + i * 3 + check) % 10 == 0) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}