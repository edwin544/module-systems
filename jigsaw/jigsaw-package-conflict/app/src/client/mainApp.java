package client;

import key.provider.KeyProvider;
//import service.provider.ServiceProvider;

public class mainApp {
    public static void main(String[] args) {

        var keyProvider = new KeyProvider();
        System.out.println("My secret key:" + keyProvider.requestKey());

       // var serviceProvider = new ServiceProvider();
       // System.out.println("My service:" + serviceProvider.requestKey());

    }
}
