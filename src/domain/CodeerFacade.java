package domain;

import domain.facade.EncodingInterface;
import domain.facade.EncryptionMethodContext;
import domain.facade.EncryptionMethodFactory;

public class CodeerFacade {
    private EncryptionMethodContext encryptionMethodContext;
    private EncryptionMethodFactory encodingInterface;

    public CodeerFacade(EncryptionMethodContext encryptionMethodContext, EncryptionMethodFactory encryptionMethodFactory) {
        this.encryptionMethodContext = encryptionMethodContext;
        this.encodingInterface = encryptionMethodFactory;
    }
    public String codeer(String tekst, String codeermethode) {
        EncodingInterface encodingInterface = EncryptionMethodFactory.createEncryptionMethod(codeermethode);
        return encodingInterface.crypt(tekst);
    }

    public String decodeer(String tekst, String codeermethode) {
        EncodingInterface encodingInterface = EncryptionMethodFactory.createEncryptionMethod(codeermethode);
        return encodingInterface.decrypt(tekst);
    }
}
