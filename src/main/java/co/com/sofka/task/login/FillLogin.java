package co.com.sofka.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.accountantregister.AccountantRegisterPage.IDENTITY;
import static co.com.sofka.userinterface.login.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillLogin implements Task {

    private String username;
    private String password;

    public FillLogin usingTheUsername(String username) {
        this.username = username;
        return this;
    }

    public FillLogin usingThePassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USERNAME, isVisible() ).forNoMoreThan(30).seconds()
        );
        actor.attemptsTo(
                JavaScriptClick.on(USERNAME),
                Enter.theValue(username).into(USERNAME),
                Enter.theValue(password).into(PASSWORD),
                JavaScriptClick.on(SUBMIT)
        );
    }
    public static FillLogin fillLogin(){
        return new FillLogin();
    }
}
