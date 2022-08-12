import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    ans++;
                }
            }
        }
        
        sb.append(ans);

        System.out.println(sb.toString());

    }

}