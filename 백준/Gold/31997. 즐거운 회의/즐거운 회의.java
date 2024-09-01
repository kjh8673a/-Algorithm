import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] schedule = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] timeTable = new int[t + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int start = Math.max(schedule[c][0], schedule[d][0]);
            int end = Math.min(schedule[c][1], schedule[d][1]);

            if (start < end) {
                timeTable[start]++;
                timeTable[end]--;
            }
        } 

        for (int i = 1; i < t; i++) {
            timeTable[i] += timeTable[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(timeTable[i]).append("\n");
        }

        System.out.println(sb);
    }
}