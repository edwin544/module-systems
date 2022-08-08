package identity.api;

import identity.api.IPerson;
import identity.api.Person;

public class Teacher implements IPerson {
    public Teacher(){
        super();
    }

    public String sayHello(String  teacherName){
        return "Hello teacher: " + teacherName;
    }




}
