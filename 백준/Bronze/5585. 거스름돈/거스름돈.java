import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int[] arr = { 500, 100, 50, 10, 5, 1 };
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += N / arr[i];
            N %= arr[i];
            if (N == 0) {
                break;
            }
        }
        System.out.println(cnt);
    }
}