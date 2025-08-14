package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import static utils.DriverManager.*;

public class Hooks {

    @Before
    public void setup() {
        startDriver();
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}
