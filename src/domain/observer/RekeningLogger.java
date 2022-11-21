package domain.observer;

import java.time.LocalDate;

public class RekeningLogger implements Observer{

    @Override
    public void update(LocalDate date, String rekeningNr, double saldo, int aantal){
        System.out.println("RL: " + "Rekeningnummer: " + rekeningNr + "\nAantal rekeningen: " + aantal);
    }

    @Override
    public void event(double bedrag, Enum eventNaam, String rekeningNr){
        System.out.println("RL: " + eventNaam.toString() + " op rekening " + rekeningNr + " en nieuw saldo " + bedrag);
    }
}