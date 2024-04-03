import java.io.*;

public class Main {
    static int n;
    static int[] sel;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sel = new int[n];
        visited = new boolean[n + 1];
        makePermutation(0);

        System.out.println(sb);
    }

    private static void makePermutation(int idx) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                sb.append(sel[i] + " ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            sel[idx] = i;
            visited[i] = true;
            makePermutation(idx + 1);
            visited[i] = false;
        }
    }

}