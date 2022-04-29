package co.com.sofka.runner.login;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/feature/login/landing.feature",
        glue = "co.com.sofka.stepdefinition",
        tags = ""
)
public class LandingRunner {
}
