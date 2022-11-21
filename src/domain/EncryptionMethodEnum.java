package domain;

public enum EncryptionMethodEnum {
    CAESAR ("Caesar", "domain.Caesar"),
    MIRROR ("Mirror", "domain.Mirror"),
    RANDOMCYPHER ("RandomCypher", "domain.RandomCypher");


    private final String omschrijving;
    private final String klasseNaam;

    EncryptionMethodEnum(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
