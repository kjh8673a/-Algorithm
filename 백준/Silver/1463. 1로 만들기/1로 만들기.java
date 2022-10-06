import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        cal(n, 0);

        System.out.println(ans);
    }

    public static void cal(int n, int cnt) {

        if(n == 1) {
            ans = Math.min(ans, cnt);
            return ;
        }

        if(cnt >= ans) return;

        if(n % 3 == 0) {
            cal(n/3, cnt+1);
        }
        if(n % 2 == 0) {
            cal(n/2, cnt+1);
        }
        cal(n-1, cnt+1);
        
    }
}