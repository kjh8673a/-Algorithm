import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String str1 = br.readLine();
            map1.put(i, str1);
        }

        for(int i = 0; i < m; i++) {
            String str2 = br.readLine();
            map2.put(str2, i);
        }

        String[] arr = new String[n];
        int idx = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(map2.containsKey(map1.get(i))) {
                arr[idx] = map1.get(i);
                idx++;
                cnt++;
            }
        }

        sb.append(cnt).append("\n");
        
        String[] ans = new String[cnt];
        idx = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != null) {
                ans[idx] = arr[i];
                idx++;
            }
        }
        
        Arrays.sort(ans);
        for(int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

}