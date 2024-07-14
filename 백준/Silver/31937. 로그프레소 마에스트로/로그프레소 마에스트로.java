import java.io.*;
import java.util.*;

public class Main {
    static class Log {
        int t;
        int a;
        int b;

        public Log(int t, int a, int b) {
            this.t = t;
            this.a = a;
            this.b = b;
        }
    }

    static Log[] logs;
    static boolean[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] virus = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            virus[num] = true;
        }

        logs = new Log[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            logs[i] = new Log(t, a, b);
        }
        Arrays.sort(logs, new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return Integer.compare(o1.t, o2.t);
            }
        });

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            tmp = new boolean[n + 1];
            int cnt = spread(i);

            if (cnt == k) {
                boolean isSame = check(virus, tmp);
                if (isSame) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean check(boolean[] virus, boolean[] tmp) {
        for (int i = 1; i < virus.length; i++) {
            if (virus[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }

    private static int spread(int start) {
        tmp[start] = true;

        int cnt = 1;
        for (Log log : logs) {
            if (tmp[log.a] && !tmp[log.b]) {
                tmp[log.b] = true;
                cnt++;
            }
        }

        return cnt;
    }

}