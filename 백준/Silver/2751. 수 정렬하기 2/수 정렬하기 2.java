import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] counting = new int[max+1-min];
        for(int i = 0; i < arr.length; i++) {
            counting[arr[i]-min]++;
        }

        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        int[] result = new int[n];
        for(int i = arr.length-1; i >= 0; i--) {
            counting[arr[i]-min]--;
            result[counting[arr[i]-min]] = arr[i];
        }

        for(int i = 0; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb.toString());

    }

}