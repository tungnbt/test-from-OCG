package OCG_java_test;

public class java_test {
	private static int a = 6;
	private static int b = 9;
	private static int c = 11;

	public static void main(String[] args) {
		System.out.println(
				"tham số: " + a + " là số chia hết cho 2, " + "giá trị 2 lần tham số là:" + calculateNumber(a));
		System.out.println(
				"tham số: " + b + " là số chia hết cho 3, " + "giá trị 3 lần tham số là:" + calculateNumber(b));
		System.out.println("tham số: " + c + " là số không chia hết cho cả 2 & 3, " + "giá trị 5 lần tham số là: "
				+ calculateNumber(c));
	}

	private static int calculateNumber(int number) {
		if (number % 2 == 0) {
			return number * 2;
		} else if (number % 3 == 0) {
			return number * 3;
		} else {
			return number * 5;
		}
	}
}
