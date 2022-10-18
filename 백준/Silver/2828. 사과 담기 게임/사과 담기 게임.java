import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 스크린
        int n = Integer.parseInt(st.nextToken());

        // 바구니
        int m = Integer.parseInt(st.nextToken());
        int start = 1;
        int end = m;

        int ans = 0;

        // 떨어지는 위치
        int j = Integer.parseInt(br.readLine());
        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());
            int move = 0;
            if (apple < start) {
                move = start - apple;
                start -= move;
                end -= move;
            } else if (apple > end) {
                move = apple - end;
                start += move;
                end += move;
            } else {
                move = 0;
            }
            ans += move;
        }

        System.out.println(ans);

    }

}