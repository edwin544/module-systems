package main.client;

import identity.api.IPerson;
import identity.api.Person;
import identity.api.Student;
import service.greet.GreetService;

public class main {

    public static void main(String[] args) {

        IPerson p = new Student("John Doe");
        var greetService = new GreetService();
        System.out.println(greetService.greetUser(p));
    }

}