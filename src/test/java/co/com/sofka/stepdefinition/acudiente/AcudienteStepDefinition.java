package co.com.sofka.stepdefinition.acudiente;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.question.acudiente.AcudienteQuestion;
import co.com.sofka.stepdefinition.Setup;
import co.com.sofka.task.acudiente.BrowseToAccountantRegister;
import co.com.sofka.util.Accountant;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


import static co.com.sofka.question.acudiente.AcudienteQuestion.acudienteQuestion;
import static co.com.sofka.task.acudiente.BrowseToAccountantRegister.browseToAccountantRegister;
import static co.com.sofka.task.acudiente.FillAccountantRegisterForm.fillAccountantRegisterForm;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class AcudienteStepDefinition extends Setup {
    private static final String ACTOR_NAME = "john";
    private final Accountant acudiente = new Accountant(2);


    @Dado("Que soy un acudiente y deseo registrarme en la plataforma")
    public void queSoyUnAcudienteYDeseoRegistrarmeEnLaPlataforma() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );

    }

    @Cuando("selecciono el formulario de registro e ingreso los campos: Nombre Acudiente, Correo, Direccion y Celular")
    public void seleccionoElFormularioDeRegistroEIngresoLosCamposNombreAcudienteCorreoDireccionYCelular() {

        theActorInTheSpotlight().attemptsTo(
                browseToAccountantRegister()
        );
        theActorInTheSpotlight().attemptsTo(

                fillAccountantRegisterForm()
                        .withId(acudiente.getIdentificacion())
                        .andName(acudiente.getNombre() + " " +acudiente.getApellido())
                        .andAddress(acudiente.getDireccion())
                        .andEmail(acudiente.getCorreo())
                        .andCellphone(acudiente.getCelular())
        );
    }
    @Entonces("la institucion me asigna un nombre de usuario\\(correo electronico) y contraseña \\(identificacion)")
    public void laInstitucionMeAsignaUnNombreDeUsuarioCorreoElectronicoYContraseñaIdentificacion() {
        theActorInTheSpotlight().should(
                seeThat(
                        acudienteQuestion(acudiente.getCorreo()).is(), equalTo(true))

        );
    }



}
