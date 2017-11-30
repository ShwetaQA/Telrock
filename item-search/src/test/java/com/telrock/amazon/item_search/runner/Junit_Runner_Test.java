package com.telrock.amazon.item_search.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/resources/Telrock-Feature-File.feature"}
, glue = {"src.test.java.com.telrock.amazon.item_search.runner"})
public class Junit_Runner_Test {

}
