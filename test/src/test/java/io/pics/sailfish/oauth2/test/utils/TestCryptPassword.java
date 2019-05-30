package io.pics.sailfish.oauth2.test.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCryptPassword {

    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        Assert.assertTrue(cryptPasswordEncoder.matches("hello-oauth2",
                                                       "$2a$10$IOngSQjUJgLZD25rBMIjUuA00s.9m3h1u/LewPBDoEM27G5yNwP7m"));
    }
}
