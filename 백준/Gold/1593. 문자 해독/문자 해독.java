import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        String S = br.readLine();

        Map<Character, Integer> wMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < g; i++) {
            wMap.put(W.charAt(i), wMap.getOrDefault(W.charAt(i), 0) + 1);
            sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1);
        }
        int answer = 0;
        if (checkMaps(wMap, sMap)) {
            answer++;
        }

        int left = 0;
        int right = g;

        while (right < l) {
            sMap.put(S.charAt(left), sMap.get(S.charAt(left)) - 1);
            sMap.put(S.charAt(right), sMap.getOrDefault(S.charAt(right), 0) + 1);

            if (checkMaps(wMap, sMap)) {
                answer++;
            }

            left++;
            right++;
        }

        System.out.println(answer);
    }

    private static boolean checkMaps(Map<Character, Integer> wMap, Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : wMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (!sMap.containsKey(key) || sMap.get(key) != value) {
                return false;
            }
        }

        return true;
    }

}