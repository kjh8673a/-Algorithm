import java.io.*;
import java.util.*;

public class Main {
    static int n, answer;
    static int[] arr, selected;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 50) {
                System.out.println(0);
                return;
            }
        }

        answer = 0;
        visited = new boolean[n];
        selected = new int[n];
        set = new HashSet<>();
        makeGroup(0);

        System.out.println(answer);
    }

    private static void makeGroup(int idx) {
        if (idx == n) {
            if (!set.contains(Arrays.toString(selected))) {
                calc();
            }
            set.add(Arrays.toString(selected));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            selected[idx] = arr[i];
            visited[i] = true;
            makeGroup(idx + 1);
            visited[i] = false;
        }
    }

    private static void calc() {
        int cnt = 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < n) {
            if (sum < 50) {
                sum += selected[right++];
            } else if (sum == 50) {
                cnt++;
                sum += selected[right++];
            } else {
                sum -= selected[left++];
            }
        }

        answer = Math.max(answer, cnt);
    }

}