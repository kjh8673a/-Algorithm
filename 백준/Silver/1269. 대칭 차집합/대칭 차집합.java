import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map1.put(num, num);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            map2.put(num, num);
        }

        int cnt1 = 0;
        for(int key : map1.keySet()) {
            if(!map2.containsKey(key)) {
                cnt1++;
            } 
        }

        int cnt2 = 0;
        for(int key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                cnt2++;
            } 
        }

        System.out.println(cnt1 + cnt2);

    }

}