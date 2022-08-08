package service.greet;

import identity.api.IPerson;
import identity.api.Person;

public class GreetService {

    public String greetUser(IPerson person) {

        var p = (Person) person;
        return person.sayHello() + ", your access key is: " + p.getAccessKey().toString(); // get Access is not part of the IPerson interface
    }
}
