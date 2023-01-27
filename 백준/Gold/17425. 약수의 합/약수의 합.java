import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        long[] arr = new long[1000001];
        Arrays.fill(arr, 1);
        for (int i = 2; i <= 1000000; i++) {
            for (int j = 2 * i; j <= 1000000; j += i) {
                arr[j] += i;
            }
        }

        for (int i = 2; i <= 1000000; i++) {
            arr[i] += i + arr[i - 1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(arr[Integer.parseInt(br.readLine())] + "\n");
        }

        System.out.println(sb.toString());

    }

}