import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> connection;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        connection = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            connection.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connection.get(a).add(b);
            connection.get(b).add(a);
        }

        visited = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(delivery(num)).append("\n");
        }

        System.out.println(sb);
    }

    private static int delivery(int num) {
        int result = 0;

        if (visited[num] == 0) {
            visited[num] = 1;
            result++;
        } else if (visited[num] == 1) {
            return 0;
        } else {
            visited[num] = 1;
        }

        for (int next : connection.get(num)) {
            if (visited[next] == 0) {
                visited[next] = 2;
                result++;
            }
        }

        return result;
    }

}
