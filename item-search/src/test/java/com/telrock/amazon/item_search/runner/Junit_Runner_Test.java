package com.telrock.amazon.item_search.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
monochrome = true,
format = { "pretty", "html:target/cucumber" },
glue = {"com.telrock.amazon.item_search.stepdefinition"},
features = {"src/test/resources/Telrock-Feature-File.feature"})
public class Junit_Runner_Test {

}
