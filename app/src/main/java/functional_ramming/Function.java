package functional_ramming;

import java.util.*;

public class Function {
    public static final int DATA_COUNT = 360;
    public final List<Double> values;

    public final double maxValue;

    private int currentIndex;

    public Function(List<Double> v) {
        this.values = v;
        this.currentIndex = 0;
        maxValue = Collections.max(values);
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public double getCurrentValue() {
        return this.values.get(currentIndex);
    }

    public double getValueAtIndex(int index) {
        return values.get(index);
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void step() {
        if (this.currentIndex < values.size() - 1) {
            this.currentIndex = this.currentIndex + 1;
        }
        else {
            this.currentIndex = 0;
        }
    }

}
