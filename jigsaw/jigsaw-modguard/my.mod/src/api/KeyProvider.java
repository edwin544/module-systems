package api;

import internal.SecretKey;

public class KeyProvider {

    public static IKey getKey(){
        return new SecretKey();
    }
}


