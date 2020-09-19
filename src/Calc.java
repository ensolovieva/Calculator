import java.util.Scanner;
public class Calc {
	private static boolean arab_numb = true;

	private static String[] pars(String input) {
		String[] parsed_input = input.split(" ");
		return parsed_input;
	}

	public static void main(String[] args) {
		Scanner input_a_value = new Scanner(System.in);
		System.out.print("Введите пример с двумя числами от 1 до 10 разделяя каждый символ пробелом: ");
		String input = input_a_value.nextLine();
		while (!input.isEmpty()) {
			String[] parsed_input = Calc.pars(input);
			String operation = parsed_input[1];
			Dopclass values;
			int value1 = 0;
			int value2 = 0;

			try {
				value1 = Integer.parseInt(parsed_input[0]);
				value2 = Integer.parseInt(parsed_input[2]);
			} catch (NumberFormatException e) {
				arab_numb = false;
			}

			if (arab_numb) {
				values = new Arabskie(value1, value2);
				try {
					if ((value1 < 1 || value1 > 10) || (value2 < 1 || value2 > 10)) {
						throw new IllegalArgumentException();
					}
				} catch (RuntimeException e) {
					throw new IllegalArgumentException("числа на вход не могут быть меньше 1 или больше 10");
				}

			} else {
				values = new Rimskie(parsed_input[0], parsed_input[2]);}


				if (operation.equals("+")) {
					values.summa();
				} else if (operation.equals("-")) {
					values.deduction();
				} else if (operation.equals("/") || operation.equals(":")) {
					values.division();
				} else if (operation.equals("*") || operation.equals("x")) {
					values.mult();
				}

				if (arab_numb) {
					System.out.println("Ответ: " + values.getRezult());
				} else {
					System.out.println("Ответ на выражение из римских цифр: " + values.getStringRezult());
				}
				System.out.println();
				System.out.print("Введите еще выражение: ");
				input = input_a_value.nextLine();
		}
	}
}
