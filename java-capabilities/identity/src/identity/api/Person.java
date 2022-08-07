package identity.api;

public class Person implements IPerson {

    private byte[] _password = {1,2,3,4};

    public String sayHello(String name) {
        return "Hello person: " + name;
    }

    private byte[] getPassword(){
        return _password;
    }
}
