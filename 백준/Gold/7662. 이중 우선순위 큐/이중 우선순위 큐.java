import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> lowQue = new PriorityQueue<>();
            PriorityQueue<Integer> highQue = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();
            
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (type) {
                    case "I":
                        lowQue.add(num);
                        highQue.add(num);
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;

                    case "D":
                        if (map.size() == 0) {
                            break;
                        }
                        if (num == 1) {
                            delete(highQue);
                        }
                        if (num == -1) {
                            delete(lowQue);
                        }
                        break;
                }

            }

            if(map.size() == 0) {
                sb.append("EMPTY").append("\n");
            }else {
                int ans = delete(highQue);
                sb.append(ans + " ");
                if(map.size() != 0) {
                    ans = delete(lowQue);
                }
                sb.append(ans).append("\n");

            }

        }

        System.out.println(sb.toString());
    }
    private static int delete(PriorityQueue<Integer> que) {

        int res = 0;
        while(true) {
            res = que.poll();

            int cnt = map.getOrDefault(res, 0);
    
            if(cnt == 0) continue;
    
            if(cnt == 1) {
                map.remove(res);
            }else {
                map.put(res, cnt-1);
            }
            break;
        }

        return res;

    }

}