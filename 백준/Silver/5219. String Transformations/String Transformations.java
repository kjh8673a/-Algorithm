import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static String solveStringTransform(ArrayList<String> lhs,
			ArrayList<String> rhs, String target) {

		String result = "";

		/* ------------------- INSERT CODE HERE ---------------------*/

		String[] arr = target.split(" ");
        for (int i = 0; i < lhs.size(); i++) {
            String from = lhs.get(i);
            String to = rhs.get(i);
            for (int j = 0; j < arr.length; j++) {
                String t = arr[j];
                String ans = "";
                for (int k = 0; k < t.length(); k++) {
                    if (t.charAt(k) == from.charAt(0)) {
                        ans += to;
                        if (k < t.length() - 1) {
                            ans += t.substring(k + 1);
                        }
                        break;
                    } else {
                        ans += String.valueOf(t.charAt(k));
                    }
                }
                arr[j] = ans;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }

		/* -------------------- END OF INSERTION --------------------*/

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTests = scanner.nextInt();		// number of test cases
		scanner.nextLine();					// go to line after nTests

		for (int t = 0; t < nTests; t++) {
			String line = scanner.nextLine();	
			Scanner scanner2 = new Scanner(line);

			ArrayList<String> lhs = new ArrayList<String>();
			ArrayList<String> rhs = new ArrayList<String>();

			while (scanner2.hasNext()) {
				String s1 = scanner2.next();
				String s2 = scanner2.next();
				lhs.add(s1);
				rhs.add(s2);
			}

			line = scanner.nextLine();		
			scanner2 = new Scanner(line);

			ArrayList<String> targets = new ArrayList<String>();
			while (scanner2.hasNext()) {
				String s1 = scanner2.next();
				targets.add(s1);
			}

			System.out.print("Transformed strings: ");
			for (String ts: targets) {
				String result = solveStringTransform(lhs, rhs, ts);
				System.out.print(result + " ");
			}
			System.out.println();
		}
	}
}
