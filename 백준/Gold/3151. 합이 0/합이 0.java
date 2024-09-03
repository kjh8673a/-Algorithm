import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int node = arr[i];
            if (node > 0) {
                break;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = node + arr[left] + arr[right];

                if (sum == 0) {
                    int lCnt = 1;
                    int rCnt = 1;
                    if (arr[left] == arr[right]) {
                        int tmp = right - left + 1;
                        answer += (tmp * (tmp - 1) / 2);
                        break;
                    }

                    while (arr[left] == arr[left + 1]) {
                        left++;
                        lCnt++;
                    }
                    while (arr[right] == arr[right - 1]) {
                        right--;
                        rCnt++;
                    }

                    answer += lCnt * rCnt;
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(answer);
    }
}