package co.com.sofka.task.acudiente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogoutAccountant implements Task  {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGOUT, isVisible() ).forNoMoreThan(30).seconds()
        );
        actor.attemptsTo(
                Scroll.to(LOGOUT),
                Click.on(LOGOUT)
        );
    }
    public static LogoutAccountant logoutAccountant()
    {
        return new LogoutAccountant();
    }
}
