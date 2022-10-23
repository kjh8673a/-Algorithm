import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static Map<Integer, Integer> move;
    static int[] visit;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 사다리 뱀 상관없이 하나의 map에 넣는다
        move = new HashMap<>();
        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move.put(a, b);
        }

        // 1~100까지 카운트할수있는 배열
        visit = new int[101];
        Arrays.fill(visit, INF);
  
        ans = 0;
        bfs();

        System.out.println(ans);

    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 출발
        queue.add(1);
        visit[1] = 0;

        while(!queue.isEmpty()) {
            int point = queue.poll();

            // 100에 도착하면 끝
            if(point == 100) {
                ans = visit[100];
                return;
            }

            // 주사위는 1~6까지
            for(int i = 1; i <= 6; i++) {
                // 주사위의 값 + 현재 위치가 100이하, 안들렸던 곳이라면
                // visit에 횟수를 저장하고
                // map에 경로가 등록되어있으면 해당 위치의 visit를 확인하고 이동시킨다
                if(point + i <= 100 && visit[point + i] == INF) {
                    visit[point + i] = visit[point] + 1;
                    if(move.containsKey(point + i)) {
                        int next = move.get(point + i);
                        if(visit[next] == INF) {
                            visit[next] = visit[point] + 1;
                            queue.add(next);
                        }
                    }else {
                        queue.add(point + i);
                    }
                }
            }
            
        }
    }
}