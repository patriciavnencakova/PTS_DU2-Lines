package datatypes;

public class Pair<T, S> {
    private final T I;
    private final S II;

    public Pair(T I, S II) {
        this.I = I;
        this.II = II;
    }

    public T getI() {
        return I;
    }

    public S getII() {
        return II;
    }
}
