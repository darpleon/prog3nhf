package functional_ramming;

import java.util.*;

public class FunctionCollection implements Iterable<Function> {
    private List<Function> functions;

    public FunctionCollection(List<Function> functions) {
        this.functions = functions;
    }

    public Iterator<Function> iterator() {
        return this.functions.iterator();
    }

    public void add(Function function) {
        functions.add(function);
    }

    public Function get(int idx) {
        return functions.get(idx);
    }

}
