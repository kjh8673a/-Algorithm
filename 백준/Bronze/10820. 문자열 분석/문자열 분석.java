import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		while((str = br.readLine()) != null) {
			int lower = 0;
			int upper = 0;
			int number = 0;
			int space = 0;

			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch-0 >= 97 && ch-0 <= 122) {
					lower++;
				}else if(ch-0 >= 65 && ch-0 <= 90) {
					upper++;
				}else if(ch-0 >= 48 && ch-0 <= 57) {
					number++;
				}else if(ch == ' ') {
					space++;
				}
			}

			System.out.println(lower + " " + upper + " " + number + " " + space);

		}

	}

}