import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    static long[] arr;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        int[] in_degree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] % 3 == 0 && arr[i] / 3 == arr[j]) {
                    list[i].add(j);
                    in_degree[j]++;
                } else if (arr[i] * 2 == arr[j]) {
                    list[i].add(j);
                    in_degree[j]++;
                }
            }
        }

        int start = 0;
        flag = false;
        while (!flag) {
            for (int i = 0; i < N; i++) {
                if (in_degree[i] == start) {
                    sb = new StringBuilder();
                    visit = new boolean[N];
                    dfs(i, 0);
                    if (flag) {
                        break;
                    }
                }
            }
            start++;
        }

    }

    public static void dfs(int a, int cnt) {
        sb.append(arr[a] + " ");
        if (cnt == N - 1) {
            System.out.println(sb);
            flag = true;
            return;
        }
        for (int next : list[a]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next, cnt + 1);
                visit[next] = false;
            }
        }
    }
}