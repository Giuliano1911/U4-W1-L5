package Media;

public interface ElementoConVolumeEDurata {

    int minVol = 0;
    int maxVol = 10;

    int minDur = 1;
    int maxDur = 60;

    int getVol();

    int getDur();

    void alzaVol(int input);

    void abbassaVol(int input);
}
