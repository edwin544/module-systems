package service.greet;

import identity.api.IPerson;
import identity.api.Person;
import identity.api.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GreetService {

    public byte[] greetUser(String name, IPerson person) throws NoSuchMethodException {
        Person p = ();
        var userService = new UserService();
        Method method = UserService.class.getDeclaredMethod("UpdatePassword");
       method.setAccessible(true);

     //   String returnValue = (String)
     //           method.invoke(p, null);

        return new byte[] {1,2,3,4}; // password;





    }
}
