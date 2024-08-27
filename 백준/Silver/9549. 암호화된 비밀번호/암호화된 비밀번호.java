import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            String after = br.readLine();
            String before = br.readLine();

            int[] origin = new int[27];
            for (int i = 0; i < before.length(); i++) {
                origin[before.charAt(i) - 'a']++;
            }

            int[] password = new int[27];
            for (int i = 0; i < before.length(); i++) {
                password[after.charAt(i) - 'a']++;
            }

            boolean result = false;
            if (compare(password, origin)) {
                result = true;
            }

            for (int i = before.length(); i < after.length() && !result; i++) {
                password[after.charAt(i - before.length()) - 'a']--;
                password[after.charAt(i) - 'a']++;

                if (compare(password, origin)) {
                    result = true;
                }
            }

            sb.append(result ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean compare(int[] password, int[] origin) {
        for (int i = 0; i < origin.length; i++) {
            if (password[i] != origin[i]) {
                return false;
            }
        }

        return true;
    }

}
