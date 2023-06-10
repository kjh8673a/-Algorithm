import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int ans = 0;

        while (left <= right) {
            if (sum == N) {
                ans++;
            }
            if (sum < N) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }

        System.out.println(ans);
    }

}
