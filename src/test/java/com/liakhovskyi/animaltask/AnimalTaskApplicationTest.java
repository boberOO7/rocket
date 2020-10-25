package com.liakhovskyi.animaltask;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTaskApplicationTest {

    @Test
    public void testPresentAnimalSound() {
        String expectedResult = "woof";

        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("dog"));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("Dog"));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("DOG"));

        expectedResult = "meow";

        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("cat"));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("Cat"));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("CAT"));
    }

    @Test
    public void testAbsentAnimalSound() {
        String expectedResult = "no such animal";

        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("Cow"));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("Duck"));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound("Goat"));
    }

    @Test
    public void testNullAndEmptyInput() {
        String expectedResult = "no such animal";

        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound(null));
        Assert.assertEquals(expectedResult, AnimalTaskApplication.getAnimalSound(""));
    }
}