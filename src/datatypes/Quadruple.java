package datatypes;

public class Quadruple<N, T, P, C> {
    private final N I;
    private final T II;
    private final P III;
    private final C IV;

    public Quadruple(N I, T II, P III, C IV) {
        this.I = I;
        this.II = II;
        this.III = III;
        this.IV = IV;
    }

    public N getI() {
        return I;
    }

    public T getII() {
        return II;
    }

    public P getIII() {
        return III;
    }

    public C getIV() {
        return IV;
    }
}
