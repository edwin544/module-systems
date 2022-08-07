package external;


import api.IKey;
import api.Key;

public class ExternalKey extends Key implements IKey {
    private static String KeyMaterial = "external1234567";
    public ExternalKey(){ super(KeyMaterial);}
}
