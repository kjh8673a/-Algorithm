import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] file = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            file[i][0] = st.nextToken();
            file[i][1] = st.nextToken();
        }

        Set<String> extension = new HashSet<>();
        for (int i = 0; i < m; i++) {
            extension.add(br.readLine());
        }

        Arrays.sort(file, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    if (extension.contains(o1[1]) == extension.contains(o2[1])) {
                        return o1[1].compareTo(o2[1]);
                    } else if (extension.contains(o1[1])) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return o1[0].compareTo(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        Arrays.stream(file).forEach(o -> sb.append(o[0] + "." + o[1]).append("\n"));

        System.out.println(sb);
    }

}