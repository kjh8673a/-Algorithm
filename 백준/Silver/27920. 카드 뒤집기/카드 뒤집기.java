import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        int left = 0;
        int right = n - 1;
        int mid = n / 2;
        arr[mid] = n;

        int num = n - 1;
        int idx = 0;
        while (num > 0) {
            if (idx % 2 == 0) {
                arr[left] = num--;
                sb.append((left + 1) + " ");
                left++;
            } else {
                arr[right] = num--;
                sb.append((right + 1) + " ");
                right--;
            }
            idx++;
        }

        sb.append(mid + 1);

        System.out.println("YES");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println(sb);
    }

}