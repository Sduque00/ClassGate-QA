package co.com.sofka.task.acudiente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


import static co.com.sofka.userinterface.login.LoginPage.REGISTRAR_ACUDIENTE;

public class BrowseToAccountantRegister implements Task {

    public static BrowseToAccountantRegister browseToAccountantRegister ()
    {
        return new BrowseToAccountantRegister();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(REGISTRAR_ACUDIENTE, isVisible() ).forNoMoreThan(20).seconds()
        );

        actor.attemptsTo(
                Scroll.to(REGISTRAR_ACUDIENTE),
                Click.on(REGISTRAR_ACUDIENTE)
        );
    }
}
