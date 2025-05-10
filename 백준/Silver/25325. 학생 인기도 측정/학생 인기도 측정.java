import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            String[] votes = br.readLine().split(" ");
            for (String name : votes) {
                map.put(name, map.get(name) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String name : keySet) {
            sb.append(name + " " + map.get(name)).append("\n");
        }

        System.out.println(sb.toString());
    }

}