package co.com.sofka.stepdefinition.landing;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.sofka.question.landing.Software.softwareValidation;
import static co.com.sofka.task.landingpage.OpenLanding.openLanding;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SoftwareStepDefinitons extends Setup {
    private static final String ACTOR_NAME = "Jack";

    @Dado("que el usuario ha ingresado a la plataforma")
    public void queElUsuarioHaIngresadoALaPlataforma(){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLanding()
        );
    }

    @Cuando("busca la informacion del software")
    public void buscaLaInformacionDelSoftware(){
    }

    @Entonces("el usuario podrá ver el funcionamiento")
    public void elUsuarioPodráVerElFuncionamiento(){
        theActorInTheSpotlight().should(
                seeThat(softwareValidation(), equalTo("¿Cómo funciona el software?"))
                        .orComplainWith(ValidationTextDoNotMatch.class)
        );
    }

}
