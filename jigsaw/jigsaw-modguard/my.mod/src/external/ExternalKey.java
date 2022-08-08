package external;


import api.IKey;
import api.Key;

public class ExternalKey extends Key implements IKey {
    private static byte[] KeyMaterial = {1,3,5,7};
    public ExternalKey(){ super(KeyMaterial);}
}
