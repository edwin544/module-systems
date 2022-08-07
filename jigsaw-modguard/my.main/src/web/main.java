package web;

import api.IKey;
import api.Key;
import api.KeyProvider;
import external.ExternalKey;
import internal.SecretKey;

public class main {
    public static void main(String[] args) {
        var provider = new KeyProvider();
        System.out.println("key:" + provider.getKey().getKey());

        var key = (Key) provider.getKey();
        System.out.println("key:" + key.getNewKey());

        IKey secKey = new SecretKey();
        System.out.println("sec key:" + ((SecretKey)secKey).getNewKey());

    }
}