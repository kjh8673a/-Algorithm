import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;
    
    static String lighter, smallant;
    static int answer;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        lighter = br.readLine();
        smallant = br.readLine();

        answer = 0;

        selected = new boolean[smallant.length()];
        pick(0);

        System.out.println(answer);
    }

    private static void pick(int idx) {
        if (idx == smallant.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(lighter);
            for (int i = 0; i < smallant.length(); i++) {
                if (selected[i]) {
                    sb.append(smallant.charAt(i));
                }
            }
            if (isValid(sb.toString())) {
                answer++;
                answer %= MOD;
            }
            return;
        }

        selected[idx] = true;
        pick(idx + 1);
        selected[idx] = false;
        pick(idx + 1);
    }

    private static boolean isValid(String str) {
        if (str.length() < 2) {
            return false;
        }

        if (str.contains("RSS") || str.contains("SPP") || str.contains("PRR")) {
            return false;
        }

        return true;
    }

}