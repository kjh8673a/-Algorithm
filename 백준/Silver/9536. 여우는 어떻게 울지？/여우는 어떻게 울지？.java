import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int len = st.countTokens();

            Set<String> set = new HashSet<>();
            while(true) {
                String s = br.readLine();
                if(s.equals("what does the fox say?")) {
                    break;
                }
                set.add(s.split(" ")[2]);
            }

            for(int i = 0; i < len; i++) {
                if(!set.contains(str.split(" ")[i])) {
                    sb.append(str.split(" ")[i] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        
    }

}