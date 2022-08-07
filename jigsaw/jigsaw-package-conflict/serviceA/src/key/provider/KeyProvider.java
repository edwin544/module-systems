package key.provider;

import internal.SecretKey;

public class KeyProvider {
    public KeyProvider(){

    }

   public String requestKey(){
        var secretKey = new SecretKey();
        return secretKey.getKey();
   }
}
