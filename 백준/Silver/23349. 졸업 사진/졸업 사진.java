import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        Set<String> names = new HashSet<>();
        TreeSet<String> placeName = new TreeSet<>();
        Map<String, int[]> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (names.contains(name)) {
                continue;
            }

            int[] tmp = map.getOrDefault(place, new int[50001]);
            for (int j = start; j < end; j++) {
                tmp[j]++;
                max = Math.max(max, tmp[j]);
            }

            map.put(place, tmp);
            placeName.add(place);
            names.add(name);
        }

        for (String place : placeName) {
            int[] table = map.get(place);
            int start = 0;
            int end = 0;
            for (int i = 0; i < table.length; i++) {
                if (start == 0 && table[i] == max) {
                    start = i;
                } else if (start != 0 && table[i] != max) {
                    end = i;
                    System.out.println(place + " " + start + " " + end);
                    return;
                }
            }
        }
    }

}