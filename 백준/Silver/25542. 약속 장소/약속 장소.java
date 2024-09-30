import java.io.*;
import java.util.*;

public class Main {
    static int n, l;
    static String[] names;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        answer = "";
        makeName(0, "");

        System.out.println(answer.isBlank() ? "CALL FRIEND" : answer);
    }

    private static void makeName(int len, String name) {
        if (!answer.isBlank()) {
            return;
        }

        if (len == l) {
            if (checkIsValidName(name)) {
                answer = name;
            }
            return;
        }

        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = names[i].charAt(len);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (max < map.get(c)) {
                max = map.get(c);
                set.clear();
                set.add(c);
            } else if (max == map.get(c)) {
                set.add(c);
            }
        }

        for (Character c : set) {
            makeName(len + 1, name + c);
        }
    }

    private static boolean checkIsValidName(String name) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < l; j++) {
                if (names[i].charAt(j) != name.charAt(j)) {
                    count++;
                }
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}