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

    public StudentRegister withDetails(Student estudiante) {
        this.estudiante = estudiante;
        return this;
    }

    public static StudentRegister studentRegister()
    {
        return new StudentRegister();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
          actor.attemptsTo(
                Enter.theValue(estudiante.getIdentificacion()).into(STUDENT_ID),

                Scroll.to(STUDENT_NAME),
                Enter.theValue(estudiante.getNombre() + " " +estudiante.getApellido()).into(STUDENT_NAME),

                Enter.theValue(estudiante.getGrupo()).into(STUDENT_GROUP),

                Enter.theValue(estudiante.getEdad()).into(STUDENT_AGE),

                Click.on(REGISTER_STUDENT)
                //Click.on(SAVE_STUDENT),
                //Click.on(CLOSE_SAVE_STUDENTS),
                //Click.on(CLEAR_LOOKFOR)

        );

    }
}
