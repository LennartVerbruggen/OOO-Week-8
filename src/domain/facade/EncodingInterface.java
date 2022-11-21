package domain.facade;

public interface EncodingInterface {
    String crypt(String tekst);
    String decrypt(String tekst);
}

