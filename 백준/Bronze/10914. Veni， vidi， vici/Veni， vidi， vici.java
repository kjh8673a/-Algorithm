import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            String s = line[i];
            for (int j = 0; j < s.length(); j += 2) {
                if (j == s.length() - 1) {
                    break;
                }
                int a = s.charAt(j) - 'a';
                int b = s.charAt(j + 1) - 'a';
                sb.append((char) ((a + b + 26 - n) % 26 + 'a'));
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

}