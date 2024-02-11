package com.example.h2demo;

import com.example.h2demo.entity.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.example.h2demo.validation.Validate.validate;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ValidationTests {
    private static Object[] testValues(){
        return new Object[] {
                new Object[] {new User("Aman", "Singh", "aman.singh@gmail.com"), true},
                new Object[] {new User("Dev", "Patel", "asdfasd"), false}
        };
    }

    @Test
    @Parameters(method="testValues")
    public void testEntry(User user, boolean expected) {
        boolean result = validate(user);
        assertEquals(result, expected);
    }
}
