import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            String[] before = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                before[i] = st.nextToken();
            }

            String[] after = new String[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                after[i] = st.nextToken();
            }

            Arrays.sort(before);
            Arrays.sort(after);

            boolean check = false;
            for(int i = 0; i < n; i++) {
                if(!before[i].equals(after[i])) {
                    check = true;
                    break;
                }
            }

            if(check) sb.append("CHEATER").append("\n");
            else sb.append("NOT CHEATER").append("\n");

        }

        System.out.println(sb.toString());        

    }

}
