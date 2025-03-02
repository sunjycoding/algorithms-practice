package leetcode.day001;

/**
 * 2469. Convert the Temperature
 *
 * @author Created by sunjy on 3/1/25
 */
public class ConvertTemperature {

    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }

}
