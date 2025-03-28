import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();

        boolean flag = true;

        if (!checkShuffle(a, b)) {
            flag = false;
        }

        if (flag && !checkStartEnd(a, b)) {
            flag = false;
        }

        if (flag && !checkExceptVowels(a, b)) {
            flag = false;
        }

        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean checkExceptVowels(String a, String b) {
        String na = "";
        String nb = "";

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o'
                    && a.charAt(i) != 'u') {
                na += a.charAt(i);
            }

            if (b.charAt(i) != 'a' && b.charAt(i) != 'e' && b.charAt(i) != 'i' && b.charAt(i) != 'o'
                    && b.charAt(i) != 'u') {
                nb += b.charAt(i);
            }
        }

        return na.equals(nb);
    }

    private static boolean checkStartEnd(String a, String b) {
        if (a.charAt(0) != b.charAt(0)) {
            return false;
        }

        if (a.charAt(a.length() - 1) != b.charAt(a.length() - 1)) {
            return false;
        }

        return true;
    }

    private static boolean checkShuffle(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }

        for (int i = 0; i < a.length(); i++) {
            char ch = b.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

}