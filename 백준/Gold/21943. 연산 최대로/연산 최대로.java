import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, p, q, max;
    static int[] arr, sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        sumList = new int[q + 1];
        max = 0;

        solve(0);

        System.out.println(max);
    }

    public static void solve(int idx) {
        if (idx == n) {
            if(check()) {
                int val = sumList[0];

                for (int i = 1; i < q + 1; i++) {
                    val *= sumList[i];
                }
    
                max = Math.max(val, max);
            }
            return;
        }

        for (int i = 0; i < q + 1; i++) {
            sumList[i] += arr[idx];
            solve(idx + 1);
            sumList[i] -= arr[idx];
        }
    }

    public static boolean check() {
        boolean isPossible = true;

        for (int i = 0; i < q + 1; i++) {
            if (sumList[i] == 0) {
                isPossible = false;
                break;
            }
        }

        return isPossible;
    }

}