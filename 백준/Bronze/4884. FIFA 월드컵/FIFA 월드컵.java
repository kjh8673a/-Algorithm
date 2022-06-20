import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long G, A, T, D;
    static long x, y;
    static long tourgames, groupgames;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            G = Integer.parseInt(st.nextToken()); // 그룹의 수
            T = Integer.parseInt(st.nextToken()); // 그룹을 구성하는 팀의 수
            A = Integer.parseInt(st.nextToken()); // 각 조에서 토너먼트로 진출하는 팀의 수
            D = Integer.parseInt(st.nextToken()); // 바로 토너먼트로 진출하는 팀의 수

            if(G == -1) {
                break;
            }

            long tour = G * A + D;
            long idx = 0;
            long a, b;
            while(true) {
                a = (long) Math.pow(2, idx-1);
                b = (long) Math.pow(2, idx);
                if(a < tour && tour <= b) {
                    y = b-tour; // 추가해야하는 팀의 수
                    tour = b;
                    break;
                }
                idx++;
            }
        
            tourgames = tour-1;
            groupgames = G * (T*(T-1)) / 2;
            x = tourgames + groupgames; // 총 열리는 경기의 수

            System.out.println(G + "*" + A + "/" + T + "+" + D + "=" + x + "+" + y);
        }

        br.close();

    }
}