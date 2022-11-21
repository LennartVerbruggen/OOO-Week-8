package domain;

import domain.observer.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String rekeningnr, double saldo, double bedrag, Enum eventNaam);
}
