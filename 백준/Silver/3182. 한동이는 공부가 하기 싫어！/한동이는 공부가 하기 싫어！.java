import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            int cnt = dfs(i);
            if (max < cnt) {
                max = cnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int idx) {
        if (visited[idx]) {
            return 0;
        }

        visited[idx] = true;
        return dfs(arr[idx]) + 1;
    }

}