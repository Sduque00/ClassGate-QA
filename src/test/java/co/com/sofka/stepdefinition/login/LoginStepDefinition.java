package co.com.sofka.stepdefinition.login;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.sofka.question.login.Login.loginValidation;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.login.FillLogin.fillLogin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition extends Setup {

    private String email = "";
    private static final String ACTOR_NAME = "User";

    @Dado("que el usuario se encuentra en la pagina")
    public void queElSeEncuentraEnLaPagina() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Cuando("inicia sesion con sus credenciales")
    public void iniciaSesionConSusCredenciales(DataTable credenciales) {
        email = credenciales.row(0).get(1);
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingTheUsername(email)
                        .usingThePassword(credenciales.row(1).get(1))
        );
    }

    @Entonces("el usuario podra ver su correo en la pagina web")
    public void elUsuarioPodraVerSuCorreoEnLaPaginaWeb() {
        theActorInTheSpotlight().should(
                seeThat(loginValidation(email), equalTo(email))
                        .orComplainWith(ValidationTextDoNotMatch.class)
        );
    }
}