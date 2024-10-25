import java.io.*;
import java.util.*;

public class Main {
    static int prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cafe = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                cafe[i][0] = Integer.parseInt(st.nextToken());
                cafe[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(cafe, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for (int i = 0; i < n; i++) {
                int x = cafe[i][0];
                int idx = i;
                ArrayList<Integer> list = new ArrayList<>();
                while (idx < n && x == cafe[idx][0]) {
                    list.add(cafe[idx][1]);
                    idx++;
                }

                prev = 0;
                if (i > 0) {
                    prev = cafe[i - 1][1];
                }
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Math.abs(prev - o1) - Math.abs(prev - o2);
                    }
                });

                for (int j = 0; j < list.size(); j++) {
                    cafe[i + j][1] = list.get(j);
                }

                i += (list.size() - 1);
            }

            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i + 1, String.valueOf(cafe[i][0] + " " + cafe[i][1]));
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(map.get(num)).append("\n");
            }

        }

        System.out.println(sb);
    }

}