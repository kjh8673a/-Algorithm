import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] knowTruth, visit;
    static boolean[][] meet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람의 수
        N = Integer.parseInt(st.nextToken());
        // 파티의 수
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        // 진실을 아는 사람 명단
        knowTruth = new boolean[N + 1];
        for (int i = 0; i < a; i++) {
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }

        // 파티 정보
        ArrayList<Integer>[] party = new ArrayList[M];
        // 서로 만난적있는지
        meet = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < b; j++) {
                for (int k = j + 1; k < b; k++) {
                    meet[party[i].get(j)][party[i].get(k)] = meet[party[i].get(k)][party[i].get(j)] = true;
                }
            }
        }

        // 진실을 아는 사람 업데이트
        visit = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i] && knowTruth[i]) {
                visit[i] = true;
                dfs(i);
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (!knowTruth[party[i].get(0)]) {
                ans++;
            }
        }

        System.out.println(ans);

    }

    public static void dfs(int num) {
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i] && meet[num][i]) {
                visit[i] = true;
                knowTruth[i] = true;
                dfs(i);
            }
        }
    }

}