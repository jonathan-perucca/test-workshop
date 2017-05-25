package com.example;

import org.junit.*;

public class LifecycleTest {

    @BeforeClass
    public static void init() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before ");
    }

    @Test
    public void one_test() {
        System.out.println("Test One");
    }

    @Test
    public void two_test() {
        System.out.println("Test Two");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
