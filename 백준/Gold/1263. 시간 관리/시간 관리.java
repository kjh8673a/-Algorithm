import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] table = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            table[i][0] = t;
            table[i][1] = s;
        }
        Arrays.sort(table, (o1, o2) -> o2[1] - o1[1]);

        int answer = table[0][1] - table[0][0];
        for (int i = 1; i < n; i++) {
            if (answer <= table[i][1]) {
                answer -= table[i][0];
            } else {
                answer = table[i][1] - table[i][0];
            }

            if (answer < 0) {
                break;
            }
        }

        System.out.println(answer < 0 ? -1 : answer);
    }
}