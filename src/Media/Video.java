package Media;

public class Video extends ElementoMultimediale implements ElementoConLuminosita, ElementoConVolumeEDurata {
    private int lum;
    private int vol;
    private final int dur;

    public Video(String t, int l, int v, int d) {
        super(t);
        this.lum = l;
        this.vol = v;
        this.dur = d;
    }

    @Override
    public int getLum() {
        return this.lum;
    }

    @Override
    public int getDur() {
        return dur;
    }

    @Override
    public int getVol() {
        return vol;
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

    @Override
    public void alzaVol(int input) {
        if(input <0)
            System.out.println("Il numero inserito non può essere negativo");
        else if (input > (maxVol - vol)) {
            System.out.println("Volume impostato al massimo(" + maxVol + ")");
            this.vol = 10;
        } else {
            vol += input;
            System.out.println("Volume aumentato di " + input + ", quindi impostato a " + vol);
        }
    }

    @Override
    public void abbassaVol(int input) {
        if(input <0)
            System.out.println("Il numero inserito non può essere negativo");
        else if (input > vol - minVol) {
            System.out.println("Volume impostato a " + minVol);
            this.vol = 1;
        } else {
            vol -= input;
            System.out.println("Volume diminuito di " + input + " ,quindi impostato a " + vol);
        }
    }

    public void play() {
        for (int i = 0; i < dur; i++) {
            System.out.println(this.getTitolo() + " " + "!".repeat(this.vol) + " " + "*".repeat(this.lum));
        }
    }
}
