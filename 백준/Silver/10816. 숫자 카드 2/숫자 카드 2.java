import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < n; j++) {
            int a = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)) {
                int cnt = (int) map.get(a);
                map.put(a, cnt + 1);
            }else{
                map.put(a, 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            int check = Integer.parseInt(st.nextToken());

            if(map.containsKey(check)) {
                sb.append(String.valueOf(map.get(check)) + " ");
            }else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());

    }
}