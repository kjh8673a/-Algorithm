import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int sum = k;
        int idx = n-1;
        int cnt = 0;
        while(sum != 0) {
            if(coin[idx] > sum) {
                idx--;
            }else {
                cnt += sum / coin[idx];
                sum %= coin[idx];
            }
        }

        System.out.println(cnt);
        
    }

}