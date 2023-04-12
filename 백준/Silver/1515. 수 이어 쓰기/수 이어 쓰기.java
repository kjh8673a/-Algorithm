import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int num = 0;
        int idx = 0;
        while (true) {
            num++;
            String tmp = String.valueOf(num);

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == line.charAt(idx)) {
                    idx++;
                }
                if (idx == line.length()) {
                    System.out.println(num);
                    return;
                }
            }
        }

    }
}
