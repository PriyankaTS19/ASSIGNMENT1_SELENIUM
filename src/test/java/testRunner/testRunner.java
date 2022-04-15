package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features= "src/test/java/feature/saucedemo.feature",
glue={"stepDefinition"},
//tags={"@scenario1","@scenario2"}       // AND condition
tags={"@scenario1,@scenario2,@scenario3"}         // OR condition
//tags= {"@Functional"}                  // Executes all scenarios despite any tags
//tags= {"@Functional","~@ignoretag"}    // Executes all scenarios and ignores ignoretag
//tags={"@scenario3"}
		)
public class testRunner {

}
