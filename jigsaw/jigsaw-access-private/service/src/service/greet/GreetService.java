package service.greet;

import identity.api.IPerson;
import identity.api.Person;
;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GreetService {

    public String greetUser(String name, IPerson person) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        var greetMessage = person.sayHello(name);

        //able to access private method getPassword() of Person class of the identity module
        //by setting opens identity in the module-info.java file
        Method privateMethod = Person.class.getDeclaredMethod("getPassword");
        privateMethod.setAccessible(true);
        var password = (byte[])privateMethod.invoke(person);

        // access private field of another class in the same module
        var userService = new UserService();
        Field privateField = UserService.class.getDeclaredField("myGrades");
        privateField.setAccessible(true);
        var myGrades = (String[])privateField.get(userService);

        return greetMessage + ", your password is hacked from identity module! pwd: " + password +
                ".\nYour grades are: " + String.join(",",myGrades);
    }


}
