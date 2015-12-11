package SimpleGUI;

/**
 * Created by Emil on 12.12.2015.
 */
class Calculation {
    public static double summ(double f, double s) {
        return f + s;
    }

    public static double multiplication(double f, double s) {
        return f * s;
    }

    public static double segmentation(double f, double s) {
        return f / s;
    }

    public static double subtraction(double f, double s) {
        return f - s;
    }

    public static double sqrt(double f, double s) {
        return Math.pow(f, s);
    }
}
