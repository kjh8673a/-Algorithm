import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        double[] arr = new double[n];
        for (int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine());
            double w = Integer.parseInt(st.nextToken());
            double h = Integer.parseInt(st.nextToken());

            double PPI = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2)) / 77;
            arr[tc] = PPI;
        }

        double[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i = tmp.length-1; i >= 0; i--) {
            for(int j = 0; j < arr.length; j++) {
                if(tmp[i] == arr[j]) {
                    sb.append((j+1) + "\n");
                    arr[j] = -1;
                    break;
                }
            }
        }

        System.out.println(sb.toString());

    }


}
