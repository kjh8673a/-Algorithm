import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 진화시킬 수 있는 포켓몬의 총 마리수
        int total = 0;

        // 가장 많이 진화시킬 수 있는 포켓몬을 찾기 위한 변수
        int max = 0;
        String maxName = "";

        for (int i = 0; i < N; i++) {

            String name = br.readLine();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int need = Integer.parseInt(st.nextToken());
            int have = Integer.parseInt(st.nextToken());

            // 현재 포켓몬이 진화할 수 있는 수
            int cnt = 0;
            while (true) {
                int now = have / need;
                if(now == 0) break;
                cnt += now;
                have = have % need + (have / need) * 2;
            }
            // 현재 포켓몬의 진화 횟수가 max보다 크면 이름 저장
            if(max < cnt) {
                maxName = name;
            }
            max = Math.max(max, cnt);
            total += cnt;
        }

        System.out.println(total);
        System.out.println(maxName);

    }

}