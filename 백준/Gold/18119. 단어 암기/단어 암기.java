import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] words = new int[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int check = 0;
            for (int j = 0; j < word.length(); j++) {
                int c = word.charAt(j) - 'a';
                check |= (1 << c);
            }
            words[i] = check;
        }

        StringBuilder sb = new StringBuilder();
        int alphabet = (1 << 27) - 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);

            if (x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u') {
                if (o == 1) {
                    alphabet &= ~(1 << x - 'a');
                } else {
                    alphabet |= (1 << x - 'a');
                }
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((alphabet & words[j]) == words[j]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

}
