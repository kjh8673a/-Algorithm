import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        Map<Integer, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int con = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            map.put(score, con + "-" + num);

            arr[score]++;
        }

        int[] check = new int[3];
        int cnt = 0;

        loop : 
        for(int i = arr.length-1; i >= 0; i--) {
            while(arr[i]-- > 0) {
                if(map.containsKey(i)) {
                    String now = map.get(i);
                    int now_con = Integer.parseInt(now.split("-")[0]);
                    int now_num = Integer.parseInt(now.split("-")[1]);
                    if(cnt < 2) {
                        check[cnt] = now_con;
                    }
                    
                    cnt++;
                    if(cnt >= 3 && check[0] == check[1]) {
                        if(check[1] == now_con) continue loop;
                    }
                    
                    sb.append(now_con + " " + now_num).append("\n");
                    if(cnt >= 3) {
                        break loop;
                    }
                }
                
            }
        }

        System.out.println(sb);
    }

}
