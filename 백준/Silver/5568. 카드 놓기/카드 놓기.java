import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int k;
    static String[] card;
    static boolean[] visit;
    static Map<String, Integer> map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        // 입력받아 string 배열에 저장 (이어붙이기 편하게 string으로)
        card = new String[n];
        visit = new boolean[n];
        for(int i = 0; i < n; i++) {
            card[i] = br.readLine();
        }

        // 만들어진 숫자를 map에 넣는다 (중복된 key는 안들어가기 때문에 map으로)
        map = new HashMap<>();

        makenum(0, "");  
        
        // map의 사이즈를 출력하면 된다
        System.out.println(map.size());

    }

    public static void makenum(int cnt, String num) {
        if(cnt == k) {
            map.put(num, 1);
            return;
        }else {
            for(int i = 0; i < card.length; i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    makenum(cnt+1, num + card[i]);
                    visit[i] = false;       
                }     
            }
        }
    }

}
