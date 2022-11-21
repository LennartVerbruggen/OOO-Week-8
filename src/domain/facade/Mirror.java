package domain.facade;

import java.util.ArrayList;

public class Mirror implements EncodingInterface{
    @Override
    public String crypt(String text) {
        ArrayList<String> letters = new ArrayList<>();
        for (int i = text.length(); i > 0; i--) {
            letters.add(text.substring(i-1, i));
        }
        return "".join("", letters);
    }

    @Override
    public String decrypt(String tekst) {
        return crypt(tekst);
    }
}