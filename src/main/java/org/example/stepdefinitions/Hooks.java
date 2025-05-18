package org.example.stepdefinitions;

import io.cucumber.java.*;
import org.example.managers.DriverManager;

public class Hooks {
    static int counter = 0;

    @BeforeAll
    public static void beforeAllTheTests() {
        System.out.println("Execution feature is started");
    }

    @Before
    public void beforeEachTest() {
        counter++;
        System.out.println("The ["+counter+"] test execution started");
    }

    @After
    public void afterEachTest() {
        DriverManager.getInstance().getDriver();
        System.out.println("The ["+counter+"] test execution finished");
    }

    @AfterAll
    public static void afterAllTheTests() {
        System.out.println("Execution feature is stopped");
    }
}
