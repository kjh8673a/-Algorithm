import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] castle = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            castle[i] = Integer.parseInt(st.nextToken());
        }

        int[][] stone = new int[k][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            stone[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int start = stone[i][0];
            int end = n + 1;
            if (i < k - 1) {
                end = stone[i + 1][0];
            }

            for (int j = start; j < end; j++) {
                stone[i][1] += castle[j];
            }
        }

        Arrays.sort(stone, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            set.add(stone[i][0]);
        }

        StringBuilder sb = new StringBuilder();
        for (int wall : set) {
            sb.append(wall).append("\n");
        }

        System.out.println(sb);
    }
}