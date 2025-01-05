import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tv = new int[n];
        for (int i = 0; i < n; i++) {
            String channel = br.readLine();
            if (channel.equals("KBS1")) {
                tv[i] = 1;
            } else if (channel.equals("KBS2")) {
                tv[i] = 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        for (int i = 1; i <= 2; i++) {
            if (tv[0] == 1 && tv[1] == 2) {
                break;
            }

            while (tv[pointer] != i) {
                sb.append(1);
                pointer++;
            }
            while (pointer >= i) {
                int tmp = tv[pointer];
                tv[pointer] = tv[pointer - 1];
                tv[pointer - 1] = tmp;
                sb.append(4);
                pointer--;
            }
        }

        System.out.println(sb.toString());
    }
}