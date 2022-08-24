import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static int ans = 0;;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        
        System.out.println(ans);
    }

    public static void dfs(int num) {
        if (num > n) {
            return;
        }
        ans = Math.max(num, ans);
        for (int i = 0; i < k; i++) {
            dfs(num * 10 + arr[i]);
        }
    }
}