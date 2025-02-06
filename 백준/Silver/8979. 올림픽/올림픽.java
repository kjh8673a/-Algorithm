import java.io.*;
import java.util.*;

public class Main {
    static int sum, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            table[i][2] = Integer.parseInt(st.nextToken());
            table[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1]) {
                    if (o2[2] == o1[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });

        int answer = 1;
        int g = table[0][1];
        int s = table[0][2];
        int b = table[0][3];
        for (int i = 1; i < n && table[0][0] != k; i++) {
            if (g != table[i][1] || s != table[i][2] || b != table[i][3]) {
                g = table[i][1];
                s = table[i][2];
                b = table[i][3];
                answer++;
            }

            if (table[i][0] == k) {
                break;
            }
        }

        System.out.println(answer);
    }

}