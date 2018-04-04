package redmart;

import java.math.BigDecimal;

public class DecimalUtil {
	public static String round(double value) {
		// BigDecimal bigDecimal = new BigDecimal(value);
		// bigDecimal = bigDecimal.setScale(numbDig,
		// BigDecimal.ROUND_HALF_UP);
		// return bigDecimal.doubleValue();
		return String.format("%.3f", value);
	}
}
