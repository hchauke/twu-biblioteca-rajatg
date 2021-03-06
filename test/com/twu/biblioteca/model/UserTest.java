package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    @Test
    public void shouldBeAbleToAuthenticate() {
        User user = new User("Name1", "email1", "12-12", "123-1234", "12345", "admin");

        assertEquals(true, user.authenticate("123-1234", "12345"));
    }

    @Test
    public void shouldBeAbleToRejectFalseLoginAttempt() {
        User user = new User("Name1", "email1", "12-12", "123-1234", "12345", "admin");

        assertEquals(false, user.authenticate("123-1234", "1245"));
    }
}
