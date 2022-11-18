import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] res, origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            res[i] = Integer.parseInt(st.nextToken());
        }

        origin = new int[N];
        for(int i = 0; i < N; i++) {
            origin[i] = i + 1;
        }

        loop:
        for(int i = 1; Math.pow(2, i) < N; i++) {
            for(int j = 1; Math.pow(2, j) < N; j++) {
                if(solve(i, j)) {
                    System.out.println(i + " " + j);
                    break loop;
                }
            }
        }

    }

    public static boolean solve(int k1, int k2) {
        int[] tmp = new int[N];

        int num = (int) Math.pow(2, k1);
        int idx = 0;
        for(int i = 0; i < N - num; i++) {
            tmp[num+i] = origin[idx++];
        }

        for(int i = 2; i <= k1 + 1; i++) {
            num = (int) Math.pow(2, k1 - i + 1);
            int start = idx;
            for(int j = start; j < start + num; j++) {
                tmp[num + j-start] = origin[idx++];
            }
        }

        tmp[0] = origin[N-1];

        int[] tmp2 = new int[N];
        num = (int) Math.pow(2, k2);
        idx = 0;
        for(int i = 0; i < N - num; i++) {
            tmp2[num+i] = tmp[idx++];
        }

        for(int i = 2; i <= k2 + 1; i++) {
            num = (int) Math.pow(2, k2 - i + 1);
            int start = idx;
            for(int j = start; j < start + num; j++) {
                tmp2[num + j-start] = tmp[idx++];
            }
        }

        tmp2[0] = tmp[N-1];

        for(int i = 0; i < N; i++) {
            if(tmp2[i] != res[i]) {
                return false;
            }
        }

        return true;
    }

}