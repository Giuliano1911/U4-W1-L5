package Media;

public class Immagine extends ElementoMultimediale implements ElementoConLuminosita {
    private int lum;

    public Immagine(String t, int l) {
        super(t);
        this.lum = l;
    }

    @Override
    public int getLum() {
        return this.lum;
    }

    @Override
    public void aumentaLum(int input) {
        if(input <0)
            System.out.println("Il numero inserito non può essere negativo");
        else if (input > (maxLum - lum)) {
            System.out.println("Luminosità impostata al massimo(" + maxLum + ")");
            this.lum = 10;
        } else {
            lum += input;
            System.out.println("Luminosità aumentata di " + input + ", quindi impostata a " + lum);
        }
    }

    @Override
    public void diminuisciLum(int input) {
        if(input <0)
            System.out.println("Il numero inserito non può essere negativo");
        else if (input > lum - minLum) {
            System.out.println("Luminosità impostata al minimo(" + minLum + ")");
            this.lum = 1;
        } else {
            lum -= input;
            System.out.println("Luminosità diminuita di " + input + " ,quindi impostata a " + lum);
        }
    }

    public void show() {
        System.out.println(this.getTitolo() + " " + "*".repeat(this.getLum()));
    }
}
