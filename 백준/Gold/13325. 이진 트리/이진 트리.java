import java.io.*;
import java.util.*;

public class Main {
    static int k, size, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        size = (int) (Math.pow(2, k + 1) - 1);

        arr = new int[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < size + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        dfs(1);

        System.out.println(ans);
    }

    private static int dfs(int node) {
        if (node * 2 >= size) {
            ans += arr[node];
            return arr[node];
        }

        int left = dfs(node * 2);
        int right = dfs(node * 2 + 1);

        ans += arr[node] + Math.abs(left - right);
        return arr[node] + Math.max(left, right);
    }

}