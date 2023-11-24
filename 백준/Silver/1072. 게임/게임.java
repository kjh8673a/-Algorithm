import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = getWinrate(x, y);

        int ans = -1;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getWinrate(x + mid, y + mid) > z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static int getWinrate(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}