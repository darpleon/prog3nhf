package functional_ramming;

import java.util.*;

public class FunctionCollection implements Iterable<Function> {
    private List<Function> functions;

    public FunctionCollection() {
        this.functions = new ArrayList<Function>();
    }

    @Override
    public Iterator<Function> iterator() {
        return this.functions.iterator();
    }

    public void add(Function function) {
        this.functions.add(function);
        System.out.println(function);
    }

    public Function get(int idx) {
        return this.functions.get(idx);
    }

}
