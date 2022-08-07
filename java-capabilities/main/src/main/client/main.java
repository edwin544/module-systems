package main.client;

import identity.api.IPerson;
import identity.api.Person;
import identity.api.Student;
import service.greet.GreetService;

import java.lang.reflect.InvocationTargetException;

public class main {

    public static void main(String[] args) throws NoSuchMethodException {
        IPerson p = new Person();
        var greetService = new GreetService();
        System.out.println(greetService.greetUser("John", p));
    }

}