package Media;

public interface ElementoConLuminosita {

    int minLum = 1;
    int maxLum = 10;

    int getLum();

    void aumentaLum(int input);

    void diminuisciLum(int input);
}
