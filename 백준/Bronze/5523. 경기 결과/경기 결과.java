import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int result = Integer.compare(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if(result == 1) {
                a++;
            }else if(result == -1) {
                b++;
            }
        }
        System.out.println(a + " " + b);
    }

}
