package identity.api;

public class Student extends Person implements IPerson {

    public Student(String name){
        super(name);
    }
    public String sayHello(){
        return "Hello, " + _name + " (student)";
    }
}
