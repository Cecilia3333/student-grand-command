package com.tw.ValidatorTest;

import com.tw.validator.InputValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {
    @Test
    public void should_return_true_with_choice_1() throws Exception {
        InputValidator inputValidator = new InputValidator("Tom,1,Math:90");
        assertTrue(inputValidator.validate1());
    }

    @Test
    public void should_return_false_with_choice_1() throws Exception {
        InputValidator inputValidator = new InputValidator("Tom,1");
        assertFalse(inputValidator.validate1());
    }

    @Test
    public void should_return_true_with_choice_2() throws Exception {
        InputValidator inputValidator = new InputValidator("1,2");
        assertTrue(inputValidator.validate2());
    }

    @Test
    public void should_return_false_with_choice_2() throws Exception {
        InputValidator inputValidator = new InputValidator("Khalid,Max");
        assertFalse(inputValidator.validate2());
    }
}
