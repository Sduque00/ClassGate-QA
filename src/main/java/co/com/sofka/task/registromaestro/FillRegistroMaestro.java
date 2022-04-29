package co.com.sofka.task.registromaestro;

import co.com.sofka.util.Teacher;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.remote.server.handler.interactions.touch.Move;

import static co.com.sofka.userinterface.registromaestro.RegistroMaestroPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FillRegistroMaestro implements Task {

    private Teacher teacher = new Teacher();
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_RegistroMaestro),
                Enter.theValue(teacher.getCorreo()).into(EMAIL),
                Enter.theValue(teacher.getDireccion()).into(DIRECCION),
                Enter.theValue("123456789").into(CONTRASEÑA),
                Enter.theValue(teacher.getCelular()).into(CELULAR),
                Enter.theValue(teacher.getNombre()).into(NOMBRE),
                Enter.theValue(teacher.getEspecialidad()).into(ESPECIALIDAD),
                Enter.theValue("123654789").into(DOCUMENTO)


        );
        actor.attemptsTo(
                Click.on(BTN_SUBMIT)

        );
        actor.attemptsTo(
                WaitUntil.the(BTN_CERRAR_SESION,isVisible()).forNoMoreThan(10).seconds(),
                //Click.on(LOADING_PAGE),
                Click.on(BTN_CERRAR_SESION));
    }

    public static FillRegistroMaestro fillRegistroMaestro(){
        return new FillRegistroMaestro();
    }
}
