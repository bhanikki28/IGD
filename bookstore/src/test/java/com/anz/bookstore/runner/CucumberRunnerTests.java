package com.anz.bookstore.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = {"src/test/resources/Features"}, glue = { "com.anz.bookstore.definitions"})
 
public class CucumberRunnerTests {
}
