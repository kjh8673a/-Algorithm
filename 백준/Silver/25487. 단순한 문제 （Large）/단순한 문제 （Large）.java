import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        StringTokenizer st;
        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // (x mod y) = (y mod z) = (z mod x)
            // x, y, z가 다 같아야 하지 않을까?

            int ans = Math.min(a, Math.min(b, c));
            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());

    }

}