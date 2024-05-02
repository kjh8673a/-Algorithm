import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int answer = -1;
        loop: for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int minus = arr[i] - arr[j];
                if (set.contains(minus)) {
                    answer = arr[i];
                    break loop;
                }

            }
        }

        System.out.println(answer);
    }

}