package co.com.sofka.task.registromaestro;

import co.com.sofka.util.Teacher;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static co.com.sofka.userinterface.registromaestro.RegistroMaestroPage.*;

public class FillRegistroMaestro implements Task {

    private Teacher teacher;
    public FillRegistroMaestro withData(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_RegistroMaestro),
                Enter.theValue(teacher.getCorreo()).into(EMAIL),
                Enter.theValue(teacher.getDireccion()).into(DIRECCION),
                Enter.theValue(teacher.getIdentificacion()).into(CONTRASEÑA),
                Enter.theValue(teacher.getCelular()).into(CELULAR),
                Enter.theValue(teacher.getNombre()).into(NOMBRE),
                Enter.theValue(teacher.getEspecialidad()).into(ESPECIALIDAD),
                Enter.theValue(teacher.getIdentificacion()).into(DOCUMENTO)
        );
        actor.attemptsTo(
                Click.on(BTN_SUBMIT)
        );
        actor.attemptsTo(
                JavaScriptClick.on(BTN_CERRAR_SESION));
    }

    public static FillRegistroMaestro fillRegistroMaestro(){
        return new FillRegistroMaestro();
    }
}
