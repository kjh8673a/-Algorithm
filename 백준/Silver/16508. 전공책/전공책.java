import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, min;
    static int[] select = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();

        int[] need = new int[26];
        for(int i = 0; i < t.length(); i++) {
            need[t.charAt(i)-'A']++;
        }

        n = Integer.parseInt(br.readLine());

        int[][] have = new int[n][27];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();

            for(int j = 0; j < title.length(); j++) {
                have[i][title.charAt(j)-'A']++;
            }

            have[i][26] = price;
        }

        min = Integer.MAX_VALUE;

        solve(need, have, 0, 0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(min);
        }

    }

    public static void solve(int[] ne, int[][] ha, int idx, int total) {
        if(idx == n) {
            if(check(ne)) {
                min = Math.min(min, total);
            }
            
            return;
        }
        
        for(int i = 0; i < 26; i++) {
            if(ha[idx][i] != 0) {
                select[i] += ha[idx][i];
            }
        }
        solve(ne, ha, idx+1, total + ha[idx][26]);
        for(int i = 0; i < 26; i++) {
            if(ha[idx][i] != 0) {
                select[i] -= ha[idx][i];
            }
        }
        solve(ne, ha, idx+1, total);
        
    }

    public static boolean check(int[] ne) {
        boolean isOk = true;

        for(int i = 0; i < 26; i++) {
            if(ne[i] - select[i] > 0) {
                isOk = false;
                break;
            }
        }

        return isOk;
    }

}