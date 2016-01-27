import java.util.Arrays;

class Parent {
	public static void identifyClass() {
		System.out.println("This is the parent class");
	}
	public void identifyObject() {
		System.out.println("This is the parent object");
	}
}

class Child extends Parent {
	public static void identifyClass() {
		System.out.println("This is the child class");
	}
	public void identifyObject() {
		System.out.println("This is the child object");
	}
}

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

		Parent p = new Parent();
		Child c = new Child();
		p.identifyClass();
		p.identifyObject();
		c.identifyClass();
		c.identifyObject();
		Parent pc = c;
		pc.identifyClass();
		pc.identifyObject();

		int[][] matrix = {{0,0,0},{0,0,0},{0,0,0}};
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matrix[i][j] = i * 3 + j;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append('[');
			for (int j = 0; j < 3; j++) {
				sb.append(matrix[i][j]);
				sb.append(',');
			}
			sb.append("]\n");
		}
		System.out.println(sb.toString());
		int[] temp = matrix[0];
		matrix[0] = matrix[2];
		matrix[2] = temp;
		sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append('[');
			for (int j = 0; j < 3; j++) {
				sb.append(matrix[i][j]);
				sb.append(',');
			}
			sb.append("]\n");
		}
		System.out.println(sb.toString());
	}
}
