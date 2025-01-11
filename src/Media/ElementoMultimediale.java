package Media;

import org.jetbrains.annotations.NotNull;

public abstract class ElementoMultimediale {
    private final String titolo;

    public ElementoMultimediale(String t) {
        this.titolo = t;
    }

    public String getTitolo() {
        return titolo;
    }
}
