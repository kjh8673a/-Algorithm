import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            if (len >= 2 * k) {
                list.add(len - (2 * k));
            } else if (len > k) {
                list.add(len - k);
            }
        }

        int answer = -1;
        int left = 1;
        int right = 1000000001;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int len : list) {
                count += len / mid;
            }

            if (count >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

}