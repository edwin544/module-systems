package internal;

import api.IKey;
import api.Key;

public class SecretKey extends Key implements IKey{
    private static String KeyMaterial = "{1,2,3,4}";
    public SecretKey(){ super(KeyMaterial);}

}
