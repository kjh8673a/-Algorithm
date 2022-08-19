import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] number;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        number = new int[m];

        visit = new boolean[n];

        map = new HashMap<>();

        find(n, m, 0);

        System.out.println(sb);

    }

    public static void find(int n, int m, int cnt) {
        if(m == cnt) {
            for(int num : number) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                number[cnt] = i+1;
                find(n, m, cnt+1);
                visit[i] = false;
            }
        }

    }

}