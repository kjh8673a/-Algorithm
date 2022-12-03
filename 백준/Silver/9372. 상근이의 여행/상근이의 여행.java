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
            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            }

            // 국가를 정점, 비행기를 간선으로 생각하면
            // 모든 국가를 연결하기 위해서는 N-1개의 간선이 필요하다(최소 스패닝 트리)
            sb.append(N - 1).append("\n");
        }

        System.out.println(sb.toString());
    }

}