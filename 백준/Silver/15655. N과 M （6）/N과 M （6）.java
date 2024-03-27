import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, sel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sel = new int[m];
        pick(0, 0);

        System.out.println(sb);
    }

    private static void pick(int idx, int cnt) {
        if (cnt == m) {
            String tmp = "";
            for (int i : sel) {
                tmp += i + " ";
            }

            sb.append(tmp).append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            sel[cnt] = arr[i];
            pick(i + 1, cnt + 1);
        }
    }

}