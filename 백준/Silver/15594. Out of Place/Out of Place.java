import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sort = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = sort[i] = num;
        }

        Arrays.sort(sort);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != sort[i]) {
                ans++;
            }
        }

        System.out.println(Math.max(0, ans - 1));

    }

}