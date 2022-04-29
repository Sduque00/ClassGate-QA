package co.com.sofka.stepdefinition.acudiente;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.question.acudiente.AcudienteQuestion;
import co.com.sofka.stepdefinition.Setup;
import co.com.sofka.task.acudiente.BrowseToAccountantRegister;
import co.com.sofka.task.acudiente.LogoutAccountant;
import co.com.sofka.task.acudiente.LookForAccountantAtLast;
import co.com.sofka.task.login.FillLogin;
import co.com.sofka.util.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


import static co.com.sofka.question.acudiente.AcudienteQuestion.acudienteQuestion;
import static co.com.sofka.question.acudiente.RegisteredAccounts.registeredAccounts;
import static co.com.sofka.question.login.Login.loginValidation;
import static co.com.sofka.task.acudiente.BrowseToAccountantRegister.browseToAccountantRegister;
import static co.com.sofka.task.acudiente.FillAccountantRegisterForm.fillAccountantRegisterForm;
import static co.com.sofka.task.acudiente.LogoutAccountant.logoutAccountant;
import static co.com.sofka.task.acudiente.LookForAccountant.lookForAccountant;
import static co.com.sofka.task.acudiente.LookForAccountantAtLast.lookForAccountantAtLast;
import static co.com.sofka.task.acudiente.StudentRegister.studentRegister;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.login.FillLogin.fillLogin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;




public class AcudienteStepDefinition extends Setup {
    private static final String ACTOR_NAME = "john";
    private final Accountant acudiente = new Accountant(3);
    private final String ADMIN_ACCOUNT = "administrativo@gmail.com";
    private final String ADMIN_PASSWORD = "123456789";

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



    @Dado("Que soy un administrativo y quiero ingresar los estudiantes de un acudiente registrado en la institucion")
    public void queSoyUnAdministrativoYQuieroIngresarLosEstudiantesDeUnAcudienteRegistradoEnLaInstitucion() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );

    }

    @Cuando("Ingreso a la plataforma y selecciono la opcion de registro de estudiante y relleno el formulario")
    public void ingresoALaPlataformaYSeleccionoLaOpcionDeRegistroDeEstudianteYRellenoElFormulario() {
        //Primero Registro al acudiente
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
        theActorInTheSpotlight().attemptsTo(
                logoutAccountant()
        );

        //Ahora ingreso en la cuenta administrativa para inscribir a sus hijos
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingTheUsername(ADMIN_ACCOUNT)
                        .usingThePassword(ADMIN_PASSWORD)
        );
        theActorInTheSpotlight().attemptsTo(
                lookForAccountant().withAccountant(acudiente)
        );
        theActorInTheSpotlight().attemptsTo(
                studentRegister()
                        .withDetails(acudiente.getHijos().get(0))
        );

        theActorInTheSpotlight().attemptsTo(
                studentRegister()
                        .withDetails(acudiente.getHijos().get(1))
        );

    }

    @Entonces("la institucion registra a los estudiantes exitosamente")
    public void laInstitucionRegistraALosEstudiantesExitosamente() {
        Student hijo1 = acudiente.getHijos().get(0);
        Student hijo2 = acudiente.getHijos().get(1);
        String nombre1 = hijo1.getNombre() + " " + hijo1.getApellido();
        String nombre2 = hijo2.getNombre() + " " + hijo2.getApellido();
        String expectedResponse = nombre1 + " " + nombre2;

        theActorInTheSpotlight().attemptsTo(
                lookForAccountantAtLast().withAccountant(acudiente)
        );


        theActorInTheSpotlight().should(
                seeThat(registeredAccounts()
                                .withAccount(acudiente)
                                .andFirstSon(hijo1)
                                .andSecondSon(hijo2)
                        , equalTo(expectedResponse))
                        .orComplainWith(ValidationTextDoNotMatch.class)
        );

    }


    @Dado("Que soy un acudiente y deseo ingresar en la plataforma")
    public void queSoyUnAcudienteYDeseoIngresarEnLaPlataforma() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Cuando("selecciono el formulario de registro e ingreso mis datos personales")
    public void seleccionoElFormularioDeRegistroEIngresoMisDatosPersonales() {
        theActorInTheSpotlight().attemptsTo(
                browseToAccountantRegister()
        );
        theActorInTheSpotlight().attemptsTo(

                fillAccountantRegisterForm()
                        .withId(acudiente.getIdentificacion())
                        .andName(acudiente.getNombre() + " " +acudiente.getApellido())
                        .andAddress(acudiente.getDireccion())
                        .andEmail(acudiente.getCorreo())
                        .andCellphone(acudiente.getCelular()),
                logoutAccountant()
        );

    }

    @Entonces("la institucion me asigna una cuenta y hago login en la pagina")
    public void laInstitucionMeAsignaUnaCuentaYHagoLoginEnLaPagina() {

        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingTheUsername(acudiente.getCorreo())
                        .usingThePassword(acudiente.getIdentificacion())
        );
        theActorInTheSpotlight().should(
                seeThat(loginValidation(acudiente.getCorreo()), equalTo(acudiente.getCorreo()))
                        .orComplainWith(ValidationTextDoNotMatch.class)
        );
    }



}
