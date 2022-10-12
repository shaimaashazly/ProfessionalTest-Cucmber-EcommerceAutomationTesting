package org.example.ecommerceTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (
 features = "src/main/resources/ecommrce-main-features",
        glue = "org/example/ecommerceStepDefs",
        tags = "@smoke",
        plugin = { "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "junit:target/cukes.xml",
        "rerun:target/rerun.txt"}
)

public class EcommerceRunner extends AbstractTestNGCucumberTests {
}
