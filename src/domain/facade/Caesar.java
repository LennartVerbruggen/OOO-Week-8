package domain.facade;

public class Caesar implements EncodingInterface{

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String caeser = "xyzabcdefghijklmnopqrstuvw";
    @Override
    public String crypt(String text) {
        if (text == null || text.trim().isEmpty() ){
            throw new IllegalArgumentException("Text mag niet leeg zijn.");
        }
        text = text.toLowerCase();
        String result = "";
        for (int i = 0; i != text.length(); i++){
            char character = text.charAt(i);

            if (!alphabet.contains(String.valueOf(character))) {
                result += character;
            } else {
                int index = alphabet.indexOf(character);
                char s = caeser.charAt(index);
                result += s;
            }
        }

        return result;
    }

    public String decrypt(String text){
        if (text == null || text.trim().isEmpty() ){
            throw new IllegalArgumentException("Text mag niet leeg zijn.");
        }
        String result = "";
        for (int i = 0; i != text.length(); i++){
            char character = text.charAt(i);

            if (!caeser.contains(String.valueOf(character))) {
                result += character;
            } else {
                int index = caeser.indexOf(character);
                char s = alphabet.charAt(index);
                result += s;
            }
        }

        return result;
    }
}