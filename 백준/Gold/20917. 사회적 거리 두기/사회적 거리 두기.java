import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int[] dist = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                dist[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(dist);

            int answer = pickDistance(dist, n, s);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int pickDistance(int[] dist, int n, int s) {
        int low = 0;
        int high = dist[n - 1] - dist[0];

        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            int cnt = 1;
            int prev = dist[0];
            for (int i = 1; i < n; i++) {
                if (dist[i] - prev >= mid) {
                    prev = dist[i];
                    cnt++;
                }
            }

            if (cnt < s) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }

        return result;
    }

}