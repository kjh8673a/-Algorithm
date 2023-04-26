import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            Map<Character, Character> map = new HashMap<>();
            String str = br.readLine();
            String s = "";
            char ch = 'a';
            for (int j = 0; j < str.length(); j++) {
                if (!map.containsKey(str.charAt(j))) {
                    map.put(str.charAt(j), ch++);
                }
                s += map.get(str.charAt(j));
            }
            arr[i] = s;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i].equals(arr[j])) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}