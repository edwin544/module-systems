package client;

import key.provider.KeyProvider;

public class mainApp {
    public static void main(String[] args) {

        var keyProvider = new KeyProvider();
        System.out.println("My secret key:" + keyProvider.requestKey());
    }
}
