package com.tt.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CommandValidatorTest {
    CommandValidator commandValidator;

    @Before
    public void setUp(){
        commandValidator = new CommandValidator();
    }

    @Test
    public void test_verifier(){
        Assert.assertTrue(commandValidator.validateCommand("NEWACCOUNT 44444"));
        Assert.assertTrue(commandValidator.validateCommand("DEPOSIT 44444 60.5"));
        Assert.assertTrue(commandValidator.validateCommand("WITHDRAW 44444 0.5"));
        Assert.assertTrue(commandValidator.validateCommand("BALANCE 44444"));
        Assert.assertTrue(commandValidator.validateCommand("BALANCE 44445"));


        Assert.assertFalse(commandValidator.validateCommand("DEPOSIT 44445"));
        Assert.assertFalse(commandValidator.validateCommand("NEWACCOUNT 44445 434"));
        Assert.assertFalse(commandValidator.validateCommand("BALANCE 44445 113"));
        Assert.assertFalse(commandValidator.validateCommand("WITHDRAW 44445 "));

    }
}
