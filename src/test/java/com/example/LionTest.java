package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class LionTest {
    private Feline feline = new Feline();

    @Test
    public void checkReturnsExceptionTest() {
        Exception exception = null; // делаем переменную для потенциального исключения
        try {
            Lion lion = new Lion("Не самец ", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void checkIsMaleTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.hasMane);
    }
    @Test
    public void checkIsFemaleTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.hasMane);
    }
    @Test
    public void checkHasManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }
    @Test
    public void checkKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(lion.getKittens(), 1);
    }
    @Test
    public void checkFoodTest() throws Exception {
        List<String> food = Arrays.asList("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", feline);
        MatcherAssert.assertThat(lion.getFood(), Matchers.hasSize(3));
        assertEquals(lion.getFood(), food);
    }

    @Test
    public void checkFamilyTest() {
        Animal animal = new Animal();
        String expected = animal.getFamily();
        String actual = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }

    @Test
    public void checkFoodHerbivoreTest() throws Exception {
        Animal  animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }
    @Test
    public void checkFoodPredatorTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void checkFoodReturnsExceptionTest() {
        Exception exception = null; // делаем переменную для потенциального исключения
        Animal  animal;
        try {
            animal = new Animal();
            animal.getFood("всеядные");
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

}
