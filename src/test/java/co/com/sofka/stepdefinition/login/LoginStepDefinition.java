package co.com.sofka.stepdefinition.login;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.Setup;
import co.com.sofka.task.registromaestro.FillRegistroMaestro;
import co.com.sofka.util.Teacher;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.sofka.question.login.Login.loginValidation;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.login.FillLogin.fillLogin;
import static co.com.sofka.task.registromaestro.FillRegistroMaestro.fillRegistroMaestro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition extends Setup {

    private String email = "";
    private static final String ACTOR_NAME = "User";

    @Dado("que el administrador se encuentra en la pagina")
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

    @Entonces("el administrador podra ver su correo en la pagina web")
    public void elUsuarioPodraVerSuCorreoEnLaPaginaWeb() {
        theActorInTheSpotlight().should(
                seeThat(loginValidation(email), equalTo(email))
                        .orComplainWith(ValidationTextDoNotMatch.class)
        );
    }

    @Dado("que el maestro se registro y se encuentra en el inicio de sesion")
    public void queElMaestroSeRegistroYSeEncuentraEnElInicioDeSesion() {
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage(),
                fillRegistroMaestro()
        );
    }

    @Cuando("llena el formulario y confirma la accion")
    public void llenaElFormularioYConfirmaLaAccion() {
        Teacher teacher = null;
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingTheUsername(teacher.getCorreo())
                        .usingThePassword("123456789")
        );
    }

    @Entonces("el maestro podra ver su correo en la pagina web")
    public void elMaestroPodraVerSuCorreoEnLaPaginaWeb() {

    }
}