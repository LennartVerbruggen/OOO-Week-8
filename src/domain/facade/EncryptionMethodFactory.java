package domain.facade;

public class EncryptionMethodFactory {
    public static EncodingInterface createEncryptionMethod(String encryptionMethodCode){
        EncryptionMethodEnum encryptionMethodEnum = EncryptionMethodEnum.valueOf(encryptionMethodCode);
        String klasseNaam = encryptionMethodEnum.getKlasseNaam();
        EncodingInterface encodingInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            encodingInterface = (EncodingInterface) dbObject;
        }
        catch (Exception e){}
        return encodingInterface;
    }
}
