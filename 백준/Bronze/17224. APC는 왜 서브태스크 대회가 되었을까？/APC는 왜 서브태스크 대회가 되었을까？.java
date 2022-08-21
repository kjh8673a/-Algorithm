import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[141];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(l >= b) {
                arr[140]++;
            }else if(l >= a) {
                arr[100]++;
            }
        }

        int cnt = 0;
        int sum = 0;
        loop : 
        for(int i = arr.length-1; i >= 0; i--) {
            while(arr[i]-- > 0) {
                cnt++;
                if(cnt > k) {
                    break loop;
                }
                sum += i;
            }
        }

        System.out.println(sum);

    }

}
