package functional_ramming;

import java.util.List;

public class Function {
    public final List<Double> values;
    public final double stepPeriod;

    private double currentValue;

    public Function(double period, List<Double> v) {
        values = v;
        stepPeriod = period / values.size();
        currentValue = values.get(0);
    }

    public double getCurrentValue() {
        return currentValue;
    }

}
