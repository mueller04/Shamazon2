import java.text.DecimalFormat;
import java.text.Format;

public class Util {

    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String formatCurrency(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return "$" + df.format(value);
    }
}
