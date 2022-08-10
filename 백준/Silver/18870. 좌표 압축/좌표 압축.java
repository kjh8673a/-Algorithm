import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() + " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] tmp = arr.clone();
		Arrays.sort(tmp);

		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		for(int i = 0; i < tmp.length; i++) {
			if(!map.containsKey(tmp[i])) {
				map.put(tmp[i], cnt++);
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i]) + " ");
		}

		System.out.println(sb.toString());

	}

}