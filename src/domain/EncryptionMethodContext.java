package domain;

import java.util.ArrayList;
import java.util.List;

public class EncryptionMethodContext {
    private EncodingInterface encodingInterface;

    public EncryptionMethodContext() {

    }

    public void setEncodingInterface(EncodingInterface encodingInterface) {
        this.encodingInterface = encodingInterface;
    }


    public String encrypt(String tekst) {
        return encodingInterface.crypt(tekst);
    }

    public String decrypt(String tekst) {
        return encodingInterface.decrypt(tekst);
    }

    public List<String> getEncryptionMethodLijst(){
        List <String> eLijst = new ArrayList<String>();
        for (EncryptionMethodEnum encryptionMethod:EncryptionMethodEnum.values()){
            eLijst.add(encryptionMethod.toString());
        }
        return eLijst;
    }
}
