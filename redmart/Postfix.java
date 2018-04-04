package redmart;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Postfix obj = new Postfix();
		System.out.println(obj.evaluate(s));
	}

	private String evaluate(String s) {
		String[] a = s.split(" ");
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(Constants.PLUS_EXPRESSION) || a[i].equals(Constants.MINUS_EXPRESSION)
					|| a[i].equals(Constants.STAR_EXPRESSION) || a[i].equals(Constants.DIVIDE_EXPRESSION)) {
				if (stack.size() < 2) {
					throw new InvalidInputException(Constants.INVALID_INPUT_EXCEPTION_MESSAGE);
				} else {
					double num1 = stack.pop();
					double num2 = stack.pop();
					switch (a[i]) {
					case Constants.STAR_EXPRESSION:
						stack.push(num2 * num1);
						break;
					case Constants.PLUS_EXPRESSION:
						stack.push(num2 + num1);
						break;
					case Constants.MINUS_EXPRESSION:
						stack.push(num2 - num1);
						break;
					case Constants.DIVIDE_EXPRESSION:
						stack.push(num2 / num1);
						break;
					}
				}
			} else if (a[i].equals(Constants.INCREMENT_EXPRESSION) || a[i].equals(Constants.DECREMENT_EXPRESSION)) {
				if (stack.isEmpty()) {
					throw new InvalidInputException(Constants.INVALID_INPUT_EXCEPTION_MESSAGE);
				} else {
					switch (a[i]) {
					case Constants.INCREMENT_EXPRESSION:
						stack.push(stack.pop() + 1);
						break;
					case Constants.DECREMENT_EXPRESSION:
						stack.push(stack.pop() - 1);
						break;
					}
				}
			} else {
				try {
					stack.push(Double.valueOf(a[i]));
				} catch (Exception e) {
					throw new InvalidInputException(e.getMessage());
				}
			}
		}
		if (stack.size() > 1) {
			throw new InvalidInputException(Constants.INVALID_INPUT_EXCEPTION_MESSAGE);
		}
		return DecimalUtil.round(stack.peek());
	}
}
