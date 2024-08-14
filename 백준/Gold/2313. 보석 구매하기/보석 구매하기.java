import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long answer = 0;
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            int l = Integer.parseInt(br.readLine());

            int max = Integer.MIN_VALUE;
            int max_left = 0;
            int max_right = 0;

            int sum = 0;
            int left = 1;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < l + 1; j++) {
                int gem = Integer.parseInt(st.nextToken());

                sum += gem;

                if (sum > max || (sum == max) && (max_right - max_left > j - left)) {
                    max = sum;
                    max_left = left;
                    max_right = j;
                }

                if (sum <= 0) {
                    sum = 0;
                    left = j + 1;
                }
            }

            answer += max;
            list.add(max_left + " " + max_right);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (String line : list) {
            sb.append(line).append("\n");
        }

        System.out.println(sb);
    }
}