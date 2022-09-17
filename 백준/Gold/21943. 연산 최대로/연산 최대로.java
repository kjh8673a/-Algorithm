import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, p, q, max;
    static int[] arr, sumList;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        max = 0;

        sumList = new int[q+1];

        solve(0, 0);

        System.out.println(max);
    }

    public static void solve(int cnt, int idx) {
        if(cnt == n) {
            int val = sumList[0];

            for(int i = 1; i < q+1; i++) {
                val *= sumList[i];
            }

            max = Math.max(val, max);
            return;
        }

        for(int i = 0; i < q + 1; i++) {
            sumList[i] += arr[idx];
            solve(cnt + 1, idx + 1);
            sumList[i] -= arr[idx];
        }
    }

}