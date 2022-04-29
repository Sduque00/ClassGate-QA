package co.com.sofka.runner.acudiente;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//tags = {"@HU10 and not @HU2"}
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(snippets = CucumberOptions.SnippetType.CAMELCASE,
    features = {"src/test/resources/feature/acudiente/registroAcudiente.feature"},
        glue = {"co.com.sofka.stepdefinition.acudiente"},
        tags = {""}

)


public class AcudienteRunner {
}
