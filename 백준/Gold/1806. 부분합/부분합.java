import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        while(left <= right && right <= N) {
            if(sum >= S) {
                if(ans == 0) {
                    ans = right - left;
                }else {
                    ans = Math.min(ans, right - left);
                }
                sum -= arr[left];
                left++;
            }else {
                sum += arr[right];
                right++;
            }
        }

        System.out.println(ans);

    }

}