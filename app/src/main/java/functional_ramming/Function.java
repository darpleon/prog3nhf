package functional_ramming;

import java.util.List;

public class Function {
    public static final int DATA_COUNT = 360;
    public final List<Double> values;

    private int currentPos;

    public Function(List<Double> v) {
        this.values = v;
        this.currentPos = 0;
    }

    public int getCurrentPos() {
        return this.currentPos;
    }

    public double getCurrentValue() {
        return this.values.get(currentPos);
    }

    public void step() {
        if (this.currentPos < values.size() - 1) {
            this.currentPos = this.currentPos + 1;
        }
        else {
            this.currentPos = 0;
        }
    }

}
