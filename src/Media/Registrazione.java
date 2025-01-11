package Media;

public class Registrazione extends ElementoMultimediale implements ElementoConVolumeEDurata {
    private int vol;
    private final int dur;

    public Registrazione(String t, int v, int d) {
        super(t);
        this.vol = v;
        this.dur = d;
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
    public void abbassaVol(int input) {
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
    public void alzaVol(int input) {
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
            System.out.println(this.getTitolo() + " " + "!".repeat(this.vol));
        }
    }
}
