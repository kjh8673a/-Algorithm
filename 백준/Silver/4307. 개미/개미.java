import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        
        StringTokenizer st;
        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // 막대의 길이
            int n = Integer.parseInt(st.nextToken()); // 개미의 수

            // 시작 끝 중 가까운 쪽으로 이동할 때 가장 빠르고
            // 먼 쪽으로 이동할 때 가장 느리다
            int min = 0;
            int max = 0;
            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                int a, b;
                // 시작점으로 가는게 더 빠르다
                if(l - num >= num) {
                    a = num;
                    b = l - num;
                }
                // 끝점으로 가는게 더 빠르다
                else {
                    a = l - num;
                    b = num;
                }

                min = Math.max(min, a);
                max = Math.max(max, b);
            }

            sb.append(min + " " + max).append("\n");

        }

        System.out.println(sb.toString());
    }

}