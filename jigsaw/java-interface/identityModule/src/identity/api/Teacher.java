package identity.api;

public class Teacher extends Person implements IPerson {

    public Teacher(String name){
        super(name);
    }
    public String sayHello(){
        return "Hello, " + _name + " (teacher)";
    }
}

