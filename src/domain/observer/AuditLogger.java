package domain.observer;

import java.time.LocalDate;

public class AuditLogger implements Observer {

    @Override
    public void update(LocalDate date, String rekeningNr, double saldo, int aantal) {
        System.out.println("AL: " + "Nieuwe rekening geopend op datum " + date.toString() + " met nummer " + rekeningNr + " en saldo " +  saldo);
    }

    @Override
    public void event(double bedrag, Enum eventNaam, String rekeningNr){
    }
}
