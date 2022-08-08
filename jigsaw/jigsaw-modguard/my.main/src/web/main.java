package web;

import api.IKey;
import api.Key;
import api.KeyProvider;
import internal.SecretKey;

public class main {
    public static void main(String[] args) {
        var provider = new KeyProvider();
        System.out.println("secret key:" + provider.getKey().getKey());
    }
}