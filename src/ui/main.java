package ui;

import domain.Bank;
import domain.Rekening;
import domain.observer.AuditLogger;
import domain.observer.RekeningLogger;

public class main {
    public static void main(String[] args) {

        Bank bank = new Bank("Patje Fox Credentials");
        AuditLogger auditor = new AuditLogger();
        RekeningLogger rekeningLogger = new RekeningLogger();

        Rekening rek1 = new Rekening("BE420");
        Rekening rek2 = new Rekening("BE69");
        rek1.stort(42069);
        rek2.stort(144);

        bank.addObserver(auditor);
        bank.addObserver(rekeningLogger);

        bank.voegRekeningToe(rek1);
        System.out.println();
        bank.voegRekeningToe(rek2);

        bank.stortOnRekening(21, rek1);
    }
}
