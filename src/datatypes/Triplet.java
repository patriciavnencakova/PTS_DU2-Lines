package datatypes;

public class Triplet<T, S, B> {
    private final T I;
    private final S II;
    private final B III;

    public Triplet(T I, S II, B III) {
        this.I = I;
        this.II = II;
        this.III = III;
    }

    public T getI() {
        return I;
    }

    public S getII() {
        return II;
    }

    public B getIII() {
        return III;
    }
}
