package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class NewLionTest {
    @RunWith(Parameterized.class)
    public static class LionParameterizedTest {

        private final String sex;
        private final Boolean expected;

        @Spy
        private Feline feline;

        public LionParameterizedTest (String sex, Boolean expected) {
            this.sex = sex;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getLionMane() {
            return new Object[][] {
                    {"Самец", true},
                    {"Самка", false},
            };
        }

        @Before
        public void setUp(){
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void checkDoesHaveManeCorrectTest () throws Exception {
            Lion lion = new Lion(sex, feline);
            boolean actual =lion.doesHaveMane();
            Assert.assertEquals(expected, actual);
        }
    }
}
