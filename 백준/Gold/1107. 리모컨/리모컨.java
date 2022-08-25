import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans;
    static int[] arr;
    static int M;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        int[] button = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                button[num] = -1;
            }
        }
        
        arr = new int[10-M];

        int idx = 0;
        for(int i = 0; i < 10; i++) {
            if(button[i] != -1) {
                arr[idx++] = button[i];
            }
        }

        ans = Math.abs(N-100);

        solve("");

        System.out.println(ans);
    }
    
    public static void solve(String num) {
        int len = num.length();
        if (len != 0 && Integer.parseInt(num) > N) {
            ans = Math.min(Math.abs(Integer.parseInt(num)-N) + len, ans);
            return;
        }
        
        if(len != 0) {
            ans = Math.min(Math.abs(Integer.parseInt(num)-N) + len, ans);
        }
        
        for (int i = 0; i < 10-M; i++) {
            if(num.length() > String.valueOf(N).length()) {
                break;
            }
            solve(num + String.valueOf(arr[i]));
        }
    }
}