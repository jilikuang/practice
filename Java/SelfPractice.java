import java.util.Arrays;

public class SelfPractice {
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println("\nargs: " + Arrays.toString(args));
		SelfPractice practice = new SelfPractice();
		char a = 'a';
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] abcCh = abc.toCharArray();
		char[] ABCCh = ABC.toCharArray();

		System.out.println(Character.getNumericValue(a));
		System.out.println((int)a);
	}
}
