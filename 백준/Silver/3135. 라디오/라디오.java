import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        
        int start = A;
        int dif = Math.abs(A - B);
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            int tmp = Math.abs(a - B);
            if(dif > tmp) {
                start = a;
                dif = tmp;
            }
        }

        int ans = 0;
        if(start != A) {
            ans++;
        }

        ans += Math.abs(start - B);

        System.out.println(ans);
        
    }

}