import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()+" ");
                st.nextToken();
                String kind = st.nextToken();

                if(map.containsKey(kind)) map.put(kind, map.get(kind) + 1);
                else map.put(kind, 1);
            }

            int ans = 1;
            for(int num : map.values()) {
                ans *= (num + 1);
            }

            sb.append((ans-1) + "\n");

        }
        System.out.println(sb.toString());

    }

}