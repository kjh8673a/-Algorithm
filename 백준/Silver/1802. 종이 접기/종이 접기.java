import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            if (check(line, line.length())) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean check(String paper, int len) {
        if (len == 1) {
            return true;
        }

        int mid = len / 2;
        String left = paper.substring(0, mid);

        StringBuilder tmp = new StringBuilder(paper.substring(mid + 1, len));
        String right = tmp.reverse().toString();

        for (int i = 0; i < mid; i++) {
            if (left.charAt(i) == right.charAt(i)) {
                return false;
            }
        }

        return check(paper, mid);
    }

}