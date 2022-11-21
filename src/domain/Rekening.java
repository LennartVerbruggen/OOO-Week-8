package domain;

public class Rekening{
    private String rekeningnummer;
    private double saldo;

    public Rekening(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
        this.saldo = 0;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public void stort(double bedrag) {
        saldo += bedrag;
    }

    public void neemOp(double bedrag) {
        saldo -= bedrag;
    }

    public void overschrijf(Rekening bestemming, double bedrag) {
        this.neemOp(bedrag);
        bestemming.stort(bedrag);
    }
}
