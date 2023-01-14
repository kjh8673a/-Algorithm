import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        int num = arr[0];
        for (int i = 1; i < n; i++) {
            sum += arr[i];
            if (arr[i] > num) {
                num = arr[i];
            }
        }
        sum += num * (n - 2);

        System.out.println(sum);

    }

}