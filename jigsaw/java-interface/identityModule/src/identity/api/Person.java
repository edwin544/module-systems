package identity.api;

public class Person implements IPerson {

    protected String _name;
    private final byte[] _accessKey = {1,2,3,4};

    public Person (String name){
        _name = name;
    }
    public String sayHello() {
        return "Hello, " + _name +  " (person)";
    }
    public byte[] getAccessKey(){
        return _accessKey;
    }
}
