package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)

public class FelineTest {
    private Feline feline;

    @Spy
    private Feline felineSpy = new Feline();

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void getMeatReturnCorrectValueTest() throws Exception {
        List<String> expectedListFood =  List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(expectedListFood);
        List<String> actualListFood = felineSpy.eatMeat();
        assertThat(expectedListFood, containsInAnyOrder(actualListFood.toArray()));
    }


    @Test
    public void getFamilyReturnCorrectValueTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensWithOutKittensCountReturnCorrectValueTest() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

}
