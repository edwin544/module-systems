package identity.api;

public class Person implements IPerson {

    private byte[] _password = {1,2,3,4};
    private byte[] getPassword(){
        return _password;
    }

    public String sayHello(String name) {
        return "Hello person: " + name;
    }


}
