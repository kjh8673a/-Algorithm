import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < n; tc++) {
            String a = br.readLine();

            int[] count = new int[10];
            int prev = 0;
            int target = -1;
            for (int i = a.length() - 1; i >= 0; i--) {
                int num = a.charAt(i) - '0';
                if (num >= prev) {
                    prev = num;
                    count[num]++;
                } else {
                    count[num]++;
                    target = i;
                    break;
                }
            }

            if (target == -1) {
                sb.append("BIGGEST").append("\n");
            } else {
                for (int i = 0; i < target; i++) {
                    sb.append(a.charAt(i));
                }

                int num = a.charAt(target) - '0';
                for (int i = 0; i < 10; i++) {
                    if (count[i] > 0 && i > num) {
                        sb.append(i);
                        count[i]--;
                        break;
                    }
                }

                for (int i = 0; i < 10; i++) {
                    while (count[i]-- > 0) {
                        sb.append(i);
                    }
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

}
