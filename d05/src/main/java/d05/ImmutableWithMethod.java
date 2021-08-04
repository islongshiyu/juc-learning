package d05;

public class ImmutableWithMethod {
    private int value = 0;

    public ImmutableWithMethod(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Immutable add(int v) {
        return new Immutable(this.value + v);
    }
}
