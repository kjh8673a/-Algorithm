import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        String withCup = "";

        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == 'S') {
                withCup += "*S";
            }else if(str.charAt(i) =='L') {
                withCup += "*LL";
                i++;
            }
            if(i == n-1) {
                withCup += "*";
            }
        }

        int cnt = 0;
        for(int i = 0; i < withCup.length(); i++) {
            if(withCup.charAt(i) == 'S' || withCup.charAt(i) == 'L') {
                if(withCup.charAt(i-1) == '*') {
                    withCup = withCup.substring(0, i-1) + " O" + withCup.substring(i+1);
                    cnt++;
                }else if(withCup.charAt(i+1) == '*') {
                    withCup = withCup.substring(0, i) + "O " + withCup.substring(i+2);
                    cnt++;
                }
            } 
        }

        sb.append(cnt);

        System.out.println(sb.toString());

    }

}