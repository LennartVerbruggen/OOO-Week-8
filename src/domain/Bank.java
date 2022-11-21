package domain;

import domain.observer.AuditLogger;
import domain.observer.Observer;
import domain.observer.RekeningLogger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank implements Subject{
    private String naam;
    private HashMap<String, Rekening> rekeningen;
    private ArrayList<Observer> observers;

    private HashMap<String, List<Observer>> events;

    public Bank(String naam) {
        this.naam = naam;
        this.rekeningen = new HashMap<String, Rekening>();
        this.observers = new ArrayList<>();
        this.events = new HashMap<>();
        events.put("voegToe", observers);
        events.put("stort", observers);
    }

    public String getNaam() {
        return naam;
    }

    public void voegRekeningToe(Rekening rekening) {
        if(rekening == null){
            throw new IllegalArgumentException("fout kut");
        }
        rekeningen.put(rekening.getRekeningnummer(), rekening);
        notifyObservers(rekening.getRekeningnummer(), rekening.getSaldo(), rekening.getSaldo(), Event.AANMAKEN);
    }

    public Rekening zoekRekening(String rekeningnummer) {
        return rekeningen.get(rekeningnummer);
    }

    public int aantalRekeningen(){
        return rekeningen.size();
    }

    public void overschrijf(String vanRekeningnummer, String naarRekeningnummer, double bedrag) {
        Rekening vanRekening = zoekRekening(vanRekeningnummer);
        Rekening naarRekening = zoekRekening(naarRekeningnummer);
        if (vanRekening != null && naarRekening != null) {
            vanRekening.overschrijf(naarRekening, bedrag);
        }
        notifyObservers(naarRekeningnummer, naarRekening.getSaldo(), bedrag, Event.OVERSCHRIJVING);
    }

    public void afhalen(String rekeningNr, double bedrag){
        Rekening rekening = zoekRekening(rekeningNr);
        if (rekening.getSaldo()<bedrag){
            System.out.println("Te weinig geld maatje!!");
        }
        else{
            rekening.neemOp(bedrag);
            notifyObservers(rekeningNr, rekening.getSaldo(), bedrag, Event.AFHALEN);
        }
    }

    public void notifyObservers(String rekeningnr, double saldo, double bedrag, Enum eventNaam){
        LocalDate date = LocalDate.now();
        int aantal = aantalRekeningen();
        for (Observer o:observers) {
            o.update(date, rekeningnr, saldo, aantal);
            if (o.getClass().equals(RekeningLogger.class)){
                o.event(bedrag, eventNaam, rekeningnr);
            } else if(o.getClass().equals(AuditLogger.class)){
                o.event(bedrag, eventNaam, rekeningnr);
            }
        }
    }

    public void stortOnRekening(double bedrag, Rekening rekening) {
        rekening.stort(bedrag);
        notifyObservers(rekening.getRekeningnummer(), rekening.getSaldo(),bedrag, Event.STORTING);
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
