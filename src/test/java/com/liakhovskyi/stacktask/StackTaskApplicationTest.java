package com.liakhovskyi.stacktask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackTaskApplicationTest {

    private List<String> correctStrings = new ArrayList<>();
    private List<String> incorrectStrings = new ArrayList<>();
    private StackTaskApplication app;

    @Before
    public void init() {
        correctStrings = Arrays.asList("([])", "([()[]()])()", "{[()()][]}()");
        incorrectStrings = Arrays.asList("(([()])))", "{(})", "((({[]]}))");
        app = new StackTaskApplication();
    }

    @Test
    public void testCorrectBracketInputWithStack() {
        for (String string : correctStrings) {
            Assert.assertTrue(app.checkBracketsWithStack(string));
        }
    }

    @Test
    public void testCorrectBracketInputWithoutStack() {
        for (String string : correctStrings) {
            Assert.assertTrue(app.checkBracketsWithoutStack(string));
        }
    }

    @Test
    public void testIncorrectBracketInputWithStack() {
        for (String string : incorrectStrings) {
            Assert.assertFalse(app.checkBracketsWithStack(string));
        }
    }

    @Test
    public void testIncorrectBracketInputWithoutStack() {
        for (String string : incorrectStrings) {
            Assert.assertFalse(app.checkBracketsWithoutStack(string));
        }
    }

    @Test
    public void testNullInputWithStack() {
        Assert.assertFalse(app.checkBracketsWithStack(null));
    }

    @Test
    public void testNullInputWithoutStack() {
        Assert.assertFalse(app.checkBracketsWithoutStack(null));
    }

    @Test
    public void testEmptyInputWithStack() {
        Assert.assertFalse(app.checkBracketsWithStack(""));
    }

    @Test
    public void testEmptyInputWithoutStack() {
        Assert.assertFalse(app.checkBracketsWithoutStack(""));
    }

}