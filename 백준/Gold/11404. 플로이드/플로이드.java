import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    dist[i][j] = 0; // 자기 자신은 0
                }else {
                    dist[i][j] = INF; // 매우 큰 값
                }
            }
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; // 시작 도시
            int b = Integer.parseInt(st.nextToken()) - 1; // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 한 번 타는데 필요한 비용

            dist[a][b] = Math.min(dist[a][b], c);
        }

        // 플로이드-워셜
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dist[i][j] >= INF) {
                    sb.append(0 + " ");
                }else {
                    sb.append(dist[i][j] + " ");
                }
                
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}