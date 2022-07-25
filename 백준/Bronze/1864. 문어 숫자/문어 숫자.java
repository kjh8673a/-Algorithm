import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str = sc.next();
			if(str.equals("#")) {
				break;
			}
			str = str.replace("-", "0");
			str = str.replace("\\", "1");
			str = str.replace("(", "2");
			str = str.replace("@", "3");
			str = str.replace("?", "4");
			str = str.replace(">", "5");
			str = str.replace("&", "6");
			str = str.replace("%", "7");
			str = str.replace("/", "-");
			
			int sum = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '-') {
					sum += (-1)*Math.pow(8, str.length()-i-1);
				}else {
					sum += (str.charAt(i) - '0')*Math.pow(8, str.length()-i-1);
				}
			}
			System.out.println(sum);
		}
	}
}