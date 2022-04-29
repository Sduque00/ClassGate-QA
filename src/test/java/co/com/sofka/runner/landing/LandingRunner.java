package co.com.sofka.runner.landing;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/feature/landing/landing.feature",
        glue = "co.com.sofka.stepdefinition.landing",
        tags = ""
)
public class LandingRunner {
}
