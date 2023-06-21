import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] city;
    static int[] chicken;
    static int min;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        city = new int[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                city[i][j] = num;
                if (num == 2)
                    cnt++;
            }
        }

        chicken = new int[cnt];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == 2) {
                    chicken[idx++] = i * 100 + j;
                }
            }
        }

        min = Integer.MAX_VALUE;
        solve(0, 0);

        System.out.println(min);

    }

    public static void solve(int idx, int cnt) {

        if (cnt == chicken.length - m) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (city[i][j] == 1) {

                        int distance = Integer.MAX_VALUE;
                        for (int k = 0; k < chicken.length; k++) {
                            if (city[chicken[k] / 100][chicken[k] % 100] == 2) {
                                int now = Math.abs(i - chicken[k] / 100) + Math.abs(j - chicken[k] % 100);
                                distance = Math.min(distance, now);
                            }
                        }
                        sum += distance;
                    }

                }
            }
            min = Math.min(min, sum);
            return;
        }

        if (idx == chicken.length) {
            return;
        }

        city[chicken[idx] / 100][chicken[idx] % 100] = 0;
        solve(idx + 1, cnt + 1);
        city[chicken[idx] / 100][chicken[idx] % 100] = 2;
        solve(idx + 1, cnt);
    }

}