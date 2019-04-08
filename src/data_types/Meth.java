package data_types;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Meth {
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static boolean var_valid(String value, int length) {
		if (length < 0) throw new IllegalArgumentException();
		
		if(value.length() <= length) return true;
		else return false;
	}
}
