package d05;

public class Immutable {
    private int value = 0;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
