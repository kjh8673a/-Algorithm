import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 65; i < 65 + 26; i++) {
            if (i < 65 + 3) {
                map.put(i, 3);
            } else if (i < 65 + 6) {
                map.put(i, 4);
            } else if (i < 65 + 9) {
                map.put(i, 5);
            } else if (i < 65 + 12) {
                map.put(i, 6);
            } else if (i < 65 + 15) {
                map.put(i, 7);
            } else if (i < 65 + 19) {
                map.put(i, 8);
            } else if (i < 65 + 22) {
                map.put(i, 9);
            } else {
                map.put(i, 10);
            }
        }

        int answer = 0;
        for (int i = 0; i < line.length(); i++) {
            answer += map.get(line.charAt(i) - 0);
        }

        System.out.println(answer);
    }

}