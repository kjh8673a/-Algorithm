import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] hi = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hi);

        int[] arc = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arc[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arc);

        long winA = 0;
        long winB = 0;
        long draw = 0;
        for (int i = 0; i < n; i++) {
            int a = hi[i];

            int drawStart = m;
            int drawEnd = -1;

            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arc[mid] >= a) {
                    drawStart = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            left = Math.max(0, drawStart - 1);
            right = m - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arc[mid] <= a) {
                    drawEnd = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            winA += drawStart;
            winB += (m - drawEnd - 1);
            draw += (drawEnd - drawStart + 1);
        }

        System.out.println(winA + " " + winB + " " + draw);
    }
}