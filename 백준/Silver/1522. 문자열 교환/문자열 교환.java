import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int aCount = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a') {
                aCount++;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            int bCount = 0;
            for (int j = i; j < i + aCount; j++) {
                if (str[j % str.length] == 'b') {
                    bCount++;
                }
            }

            ans = Math.min(ans, bCount);
        }

        System.out.println(ans);
    }

}
