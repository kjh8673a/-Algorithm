import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken());
                switch (j) {
                    case 0:
                        sum += n * 6;
                        break;
                    case 1:
                        sum += n * 3;
                        break;
                    case 2:
                        sum += n * 2;
                        break;
                    case 3:
                        sum += n * 1;
                        break;
                    case 4:
                        sum += n * 2;
                        break;
                }
            }

            System.out.print(sum + " ");
        }

    }

}
