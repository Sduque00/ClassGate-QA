package co.com.sofka.task.acudiente;

import co.com.sofka.util.Accountant;
import co.com.sofka.util.Student;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.IDENTITY;
import static co.com.sofka.userinterface.accountantregister.StudentRegisterPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class StudentRegister implements Task {
    private Student estudiante;
    private Accountant acudiente;

    public StudentRegister withDetails(Student estudiante) {
        this.estudiante = estudiante;
        return this;
    }
    public StudentRegister withAccountant(Accountant acudiente) {
        this.acudiente = acudiente;
        return this;
    }

    public static StudentRegister studentRegister()
    {
        return new StudentRegister();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOOKFOR_ACCOUNTANT, isVisible() ).forNoMoreThan(30).seconds()
        );
        actor.attemptsTo(
                Scroll.to(LOOKFOR_ACCOUNTANT),

                Enter.theValue(acudiente.getApellido()).into(LOOKFOR_ACCOUNTANT)
        );
        actor.attemptsTo(
                Scroll.to(ADD_STUDENTS),
                Click.on(ADD_STUDENTS),
                Scroll.to(STUDENT_ID),
                Enter.theValue(estudiante.getIdentificacion()).into(STUDENT_ID),

                Scroll.to(STUDENT_NAME),
                Enter.theValue(estudiante.getNombre() + " " +estudiante.getApellido()).into(STUDENT_ID),

                Scroll.to(STUDENT_GROUP),
                Enter.theValue(estudiante.getGrupo()).into(STUDENT_GROUP),

                Scroll.to(STUDENT_AGE),
                Enter.theValue(estudiante.getEdad()).into(STUDENT_AGE),

                Scroll.to(REGISTER_STUDENT),
                Click.on(REGISTER_STUDENT)

        );

    }
}
