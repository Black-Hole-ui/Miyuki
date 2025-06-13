package com.example.latihan_praktikum_10;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectValidatorTest {

    @Test
    public void testValidName() {
        assertTrue(ProjectValidator.isValidName("ProjectA"));
    }

    @Test
    public void testInvalidName_null() {
        assertFalse(ProjectValidator.isValidName(null));
    }

    @Test
    public void testInvalidName_short() {
        assertFalse(ProjectValidator.isValidName("Hi"));
    }
}
