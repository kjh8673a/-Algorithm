import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] arr, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        selected = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        makeOrder(0, 0);

        System.out.println(ans);
    }

    private static void makeOrder(int idx, int check) {
        if (idx == N) {
            ans = Math.max(caculate(), ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((check & (1 << i)) == 0) {
                selected[idx] = i;
                makeOrder(idx + 1, check + (1 << i));
            }
        }
    }

    private static int caculate() {
        int result = 0;
        for (int i = 1; i < N; i++) {
            result += Math.abs(arr[selected[i]] - arr[selected[i - 1]]);
        }
        return result;
    }

}
