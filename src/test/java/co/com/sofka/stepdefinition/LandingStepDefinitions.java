package co.com.sofka.stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import javax.swing.*;

import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LandingStepDefinitions extends Setup{
    private static final String ACTOR_NAME = "Jack";

    @Dado("que el usuario ingresa a la plataforma")
    public void queElUsuarioIngresaALaPlataforma(){
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Cuando("busca la informacion de la herramienta")
    public void buscaLaInformacionDeLaHerramienta(){}
}
