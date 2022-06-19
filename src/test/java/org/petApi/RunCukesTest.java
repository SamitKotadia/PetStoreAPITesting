package org.petApi;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.petApi.utility.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        tags = "@getService",
        plugin = "json:target/cucumber.json")

public class RunCukesTest {
    @BeforeClass
    public static void setBaseURL() {
        ConfigFileReader configFileReader = new ConfigFileReader("API-Env.properties");
        RestAssured.baseURI = configFileReader.getApiEnvironment();
    }
}

