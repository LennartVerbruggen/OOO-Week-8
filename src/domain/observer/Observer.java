package domain.observer;

import java.time.LocalDate;

public interface Observer {
    void update(LocalDate date, String rekeningNr, double saldo, int aantal);
    void event(double bedrag, Enum eventNaam, String rekeningNr);
}