import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger n = new BigInteger(br.readLine().toString());

        String a = "";
        int cnt = 0;
        for(int i = 2; i <= 10; i++) {
            a = n.toString(i);
            Boolean check = true;
            for(int j = 0; j < a.length()/2; j++) {
                if(a.charAt(j) != a.charAt(a.length()-j-1)) {
                    check = false;
                    break;
                }
            }
            if(check) {
                sb.append(i + " " + a + "\n");
                cnt++;
            }
        }

        if(cnt == 0) {
            sb.append("NIE"+ "\n");
        }
        System.out.println(sb);
        
    }

}