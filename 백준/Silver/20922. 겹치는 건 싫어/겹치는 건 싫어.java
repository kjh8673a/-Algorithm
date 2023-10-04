import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        count[arr[0]]++;
        int ans = 1;
        int left = 0;
        for (int i = 1; i < n; i++) {
            count[arr[i]]++;
            if (count[arr[i]] > k) {
                for (int j = left; j < i; j++) {
                    count[arr[j]]--;
                    if (arr[i] == arr[j]) {
                        left = j + 1;
                        break;
                    }
                }
            }

            ans = Math.max(ans, i - left + 1);
        }

        System.out.println(ans);
    }

}
