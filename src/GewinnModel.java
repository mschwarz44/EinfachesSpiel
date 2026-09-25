public class GewinnModel {
    int gesamtPunkte;
    int spielerZahl;
    int computerZahl;
    int rundenErgebnis;
    GewinnModel() {
        gesamtPunkte = 0;
        spielerZahl = 0;
        computerZahl = 0;
        rundenErgebnis = 0;
    }
    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }
    public void berechneGesamtPunkte(int spielerZahl) {
        berechneComputerZahl();
        int differenz = spielerZahl - gesamtPunkte;
        if(differenz == 0) {
            rundenErgebnis = 5;
        }else if(differenz == 1 || differenz == -1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
    }
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }
    public int getComputerZahl() {
        return computerZahl;
    }
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public boolean hatGewonnen() {
        return false;
    }
    public boolean hatVerloren() {
        return false;
    }
}
