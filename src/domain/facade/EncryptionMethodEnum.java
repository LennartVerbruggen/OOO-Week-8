package domain.facade;

public enum EncryptionMethodEnum {
    CAESAR ("Caesar", "domain.facade.Caesar"),
    MIRROR ("Mirror", "domain.facade.Mirror"),
    RANDOMCYPHER ("RandomCypher", "domain.facade.RandomCypher");


    private final String omschrijving;
    private final String klasseNaam;

    EncryptionMethodEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
