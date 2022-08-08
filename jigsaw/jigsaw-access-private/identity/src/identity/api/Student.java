package identity.api;

public class Student implements IPerson {
    public Student(){
        super();
    }

    public String sayHello(String  studentName){

        var student = new Student();
        return "Hello student: " + studentName;
    }


}
