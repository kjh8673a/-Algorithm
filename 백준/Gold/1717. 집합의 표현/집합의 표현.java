import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                grouping(a, b);
            } else if (type == 1) {
                sb.append(check(a, b)? "YES" : "NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int findGroup(int a) {
        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = findGroup(arr[a]);
        }
    }

    private static void grouping(int a, int b) {
        int pa = findGroup(a);
        int pb = findGroup(b);

        if (pa < pb) {
            arr[pb] = pa;
        } else {
            arr[pa] = pb;
        }
    }

    private static boolean check(int a, int b) {
        int pa = findGroup(a);
        int pb = findGroup(b);

        if (pa == pb) {
            return true;
        } else {
            return false;
        }
    }
}
