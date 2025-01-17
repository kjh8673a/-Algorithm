import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            map.putIfAbsent(ch, i);
        }

        for (int i = 0; i < 26; i++) {
            if (map.containsKey(i)) {
                System.out.print(map.get(i) + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }
    }

}