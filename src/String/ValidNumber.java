package String;
//https://leetcode.com/problems/valid-number/
public class ValidNumber {

	public static void main(String[] args) {
		String s12 = "95a54e53";
		System.out.println(isNumber(s12));
	}

	public static boolean isNumber(String s) {
		int dotIndex = -1;
		int eIndex = -1;
		int signIndex = -1;

		int lastDigitIndex = -1;

		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				// update digit index
				lastDigitIndex = i;

			} else if (c == '.') {
				// check already dot, e-sign exist or not
				if (dotIndex != -1 || eIndex != -1 || (n == 1 && i == 0))
					return false;
				dotIndex = i;

			} else if (Character.isLetter(c)) {
				// check other Character exist other than e and E
				if (c != 'e' && c != 'E')
					return false;

				// check already e/E exist or not,
				// check it is last chractere or not
				// check already seen digit or not
				if (eIndex != -1 || i == 0 || i == n - 1 || lastDigitIndex == -1)
					return false;

				eIndex = i;

			} else if (c == '+' || c == '-') {

				// check previous character is e/E or not
				if (i > 0 && (eIndex == -1 || i - eIndex > 1))
					return false;

				// check previous charcter is sign or not
				if (i > 0 && signIndex == i - 1)
					return false;

				signIndex = i;

			}
		}

		// check any digit exist or not
		if (lastDigitIndex == -1)
			return false;

		// check sign character shouldn't be last character
		if (signIndex != -1 && lastDigitIndex < signIndex)
			return false;

		return true;
	}
}
