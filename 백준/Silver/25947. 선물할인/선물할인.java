import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int ans = -1;
        long sum = 0;
        for (int i = 0; i < a; i++) {
            sum += arr[i] / 2;
            if (sum > b) {
                ans = i;
                break;
            }
        }

        if (sum <= b) {
            for (int i = a; i < n; i++) {
                sum += arr[i] / 2;
                sum += arr[i - a] / 2;
                if (sum > b) {
                    ans = i;
                    break;
                }
            }
        }

        if(ans == -1) {
            ans = n;
        }

        System.out.println(ans);

    }

}