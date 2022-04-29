package co.com.sofka.task.acudiente;

import co.com.sofka.util.Accountant;
import co.com.sofka.util.Student;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.accountantregister.StudentRegisterPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LookForAccountantAtLast implements Task {
    private Student estudiante;
    private Accountant acudiente;

    public LookForAccountantAtLast withAccountant(Accountant acudiente) {
        this.acudiente = acudiente;
        return this;
    }

    public static LookForAccountantAtLast lookForAccountantAtLast()
    {
        return new LookForAccountantAtLast();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String nombre = acudiente.getNombre()+ " "+acudiente.getApellido();
        actor.attemptsTo(
                Switch.toActiveElement(),
                WaitUntil.the(CLOSE_SAVE_STUDENTS, isVisible() ).forNoMoreThan(30).seconds(),
                Click.on(CLOSE_SAVE_STUDENTS),

                Switch.toActiveElement(),
                WaitUntil.the(CLEAR_LOOKFOR, isVisible() ).forNoMoreThan(30).seconds(),
                Click.on(CLEAR_LOOKFOR),

                Switch.toActiveElement(),
                WaitUntil.the(LOOKFOR_ACCOUNTANT, isVisible() ).forNoMoreThan(30).seconds(),
                Enter.keyValues(nombre.substring(0,1)).into(LOOKFOR_ACCOUNTANT),
                JavaScriptClick.on(LOOKFOR_ACCOUNTANT),
                Enter.keyValues(nombre.substring(1,2)).into(LOOKFOR_ACCOUNTANT),
                JavaScriptClick.on(LOOKFOR_ACCOUNTANT),
                Enter.keyValues(nombre.substring(2,3)).into(LOOKFOR_ACCOUNTANT),
                JavaScriptClick.on(LOOKFOR_ACCOUNTANT),
                Enter.keyValues(nombre.substring(3,4)).into(LOOKFOR_ACCOUNTANT),
                JavaScriptClick.on(LOOKFOR_ACCOUNTANT),
                Enter.keyValues(nombre.substring(4,5)).into(LOOKFOR_ACCOUNTANT),
                Click.on(ADD_STUDENTS)
        );
    }
}
