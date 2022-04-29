package co.com.sofka.stepdefinition.landing;

import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import co.com.sofka.exception.ValidationTextDoNotMatch;
import javax.swing.*;
import static co.com.sofka.task.landingpage.OpenLanding.openLanding;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static co.com.sofka.question.landing.Landing.landingValidation;


public class LandingStepDefinitions extends Setup {
    private static final String ACTOR_NAME = "Jack";

    @Dado("que el usuario ingresa a la plataforma")
    public void queElUsuarioIngresaALaPlataforma(){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLanding()
        );
    }

    @Cuando("busca la informacion de la herramienta")
    public void buscaLaInformacionDeLaHerramienta(){
    }

    @Entonces("el usuario podrá leer la informacion")
    public void elUsuarioPodráLeerLaInformacion(){
        theActorInTheSpotlight().should(
                seeThat(landingValidation(), equalTo("Paquete base"))
                        .orComplainWith(ValidationTextDoNotMatch.class)
        );
    }
}
